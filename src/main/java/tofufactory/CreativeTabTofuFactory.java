package tofufactory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import tofufactory.plugin.PluginTofuFactory;

public class CreativeTabTofuFactory extends CreativeTabs
{
    public CreativeTabTofuFactory(String label)
    {
        super(label);
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * the itemID for the item to be displayed on the tab
     */
    public Item getTabIconItem()
    {
        return PluginTofuFactory.zundaIngot;
    }
}
