package tofufactory.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemTofuGem extends ItemSetBase
{
    @SideOnly(Side.CLIENT)
    private IIcon[] TofuGemIcon;
    private String[] tofuGemName;

    public ItemTofuGem(String[] name)
    {
        super();
        this.tofuGemName = name;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public boolean isDamageable()
    {
        return false;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List itemList)
    {
        for (int i = 0; i < this.tofuGemName.length; ++i)
        {
            itemList.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.TofuGemIcon = new IIcon[this.tofuGemName.length];

        for (int i = 0; i < this.tofuGemName.length; ++i)
        {
            String name = this.tofuGemName[i];
            this.TofuGemIcon[i] = register.registerIcon("tofufactory:gem/tofuGem" + name);
        }

        this.itemIcon = register.registerIcon("tofufactory:zunda_ingot");
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    public IIcon getIconFromDamage(int par1)
    {
        return par1 >= 0 && par1 < this.TofuGemIcon.length ? this.TofuGemIcon[par1] : this.itemIcon;
    }

    @Override
    public String[] getItemList()
    {
        return this.tofuGemName;
    }

    @Override
    public String getItemSetName()
    {
        return "gem";
    }
}