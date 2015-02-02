package tofufactory.item;

import net.minecraft.item.Item;
import tofufactory.TofuFactory;

public class ItemTofuFactory extends Item
{
    public ItemTofuFactory()
    {
        super();
        this.setCreativeTab(TofuFactory.tabsTofuFactory);
    }

    /**
     * Sets the unlocalized name of this item to the string passed as the parameter, prefixed by "item."
     */
    @Override
    public Item setUnlocalizedName(String par1Str)
    {
        super.setUnlocalizedName(par1Str);
        return this;
    }
}
