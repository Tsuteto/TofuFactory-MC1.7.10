package tofufactory.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemTofuGear extends ItemSetBase
{
    @SideOnly(Side.CLIENT)
    private IIcon[] TofuGearIcon;
    public String[] tofuGearNames;

    public ItemTofuGear(String[] name)
    {
        super();
        this.tofuGearNames = name;
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
        for (int i = 0; i < this.tofuGearNames.length; ++i)
        {
            itemList.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.TofuGearIcon = new IIcon[this.tofuGearNames.length];

        for (int i = 0; i < this.tofuGearNames.length; ++i)
        {
            String name = this.tofuGearNames[i];
            this.TofuGearIcon[i] = register.registerIcon("tofufactory:gear/gear" + name);
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
        return par1 >= 0 && par1 < this.TofuGearIcon.length ? this.TofuGearIcon[par1] : this.itemIcon;
    }

    @Override
    public String[] getItemList()
    {
        return this.tofuGearNames;
    }

    @Override
    public String getItemSetName()
    {
        return "gear";
    }
}
