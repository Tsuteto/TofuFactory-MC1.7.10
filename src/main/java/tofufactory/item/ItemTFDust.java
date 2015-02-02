package tofufactory.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemTFDust extends ItemSetBase
{
    @SideOnly(Side.CLIENT)
    private IIcon[] dustIcons;
    private final String[] dustNames;

    public ItemTFDust(String[] name)
    {
        super();
        this.dustNames = name;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public boolean isDamageable()
    {
        return false;
    }

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
        for (int i = 0; i < this.dustNames.length; ++i)
        {
            itemList.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.dustIcons = new IIcon[this.dustNames.length];

        for (int i = 0; i < this.dustNames.length; ++i)
        {
            String name = this.dustNames[i];
            this.dustIcons[i] = register.registerIcon("tofufactory:dust/dust" + name);
        }

        this.itemIcon = register.registerIcon("tofufactory:zunda_ingot");
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    public IIcon getIconFromDamage(int par1)
    {
        return par1 >= 0 && par1 < this.dustIcons.length ? this.dustIcons[par1] : this.itemIcon;
    }

    @Override
    public String[] getItemList()
    {
        return this.dustNames;
    }

    @Override
    public String getItemSetName()
    {
        return "dust";
    }

}
