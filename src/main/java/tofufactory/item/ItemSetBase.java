package tofufactory.item;

import net.minecraft.item.ItemStack;
import tofufactory.TofuFactory;

public abstract class ItemSetBase extends ItemTofuFactory
{
    @Override
    public String getUnlocalizedName(ItemStack itemstack)
    {
        int dmg = itemstack.getItemDamage();
        String[] list = this.getItemList();
        return "item." + this.getFullName(list, dmg >= 0 && dmg < list.length ? dmg : 0);
    }

    private String getFullName(String[] list, int dmg)
    {
        return TofuFactory.resourceDomain + (this.getItemSetName() != null ? this.getItemSetName() + "." : "") + list[dmg];
    }

    abstract public String[] getItemList();

    public String getItemSetName()
    {
        return null;
    }

}
