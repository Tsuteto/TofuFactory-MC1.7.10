package tofufactory.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import tofufactory.TofuFactory;
import tsuteto.tofu.util.Utils;

import java.util.List;

public abstract class ItemSetBase extends ItemTofuFactory
{
    protected String[] names;
    @SideOnly(Side.CLIENT)
    protected IIcon[] icons;

    public ItemSetBase(String[] names)
    {
        super();
        this.names = names;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        int dmg = itemstack.getItemDamage();
        String[] list = this.names;
        return "item." + this.getFullName(list, dmg >= 0 && dmg < list.length ? dmg : 0);
    }

    private String getFullName(String[] list, int dmg)
    {
        return TofuFactory.resourceDomain + (this.getItemSetName() != null ? this.getItemSetName() + "." : "") + list[dmg];
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List itemList)
    {
        for (int i = 0; i < this.names.length; ++i)
        {
            itemList.add(new ItemStack(this, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    public IIcon getIconFromDamage(int par1)
    {
        return par1 >= 0 && par1 < this.icons.length ? this.icons[par1] : this.itemIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.icons = new IIcon[this.names.length];
        String setName = this.getItemSetName();

        for (int i = 0; i < this.names.length; ++i)
        {
            String name = this.names[i];
            if (getItemSetName() != null)
            {
                this.icons[i] = register.registerIcon("tofufactory:" + setName + "/" + setName + Utils.capitalize(name));
            }
            else
            {
                this.icons[i] = register.registerIcon("tofufactory:" + name);
            }
        }

        this.itemIcon = register.registerIcon("tofufactory:zundaIngot");
    }

    public String getItemSetName()
    {
        return null;
    }

}
