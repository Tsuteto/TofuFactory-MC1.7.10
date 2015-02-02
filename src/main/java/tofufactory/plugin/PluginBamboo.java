package tofufactory.plugin;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tofufactory.TofuFactory;

import java.util.List;

public class PluginBamboo
{
    public static void Init()
    {
        registeOreDictionary();
    }

    public static void registeOreDictionary()
    {
        try
        {
            List<ItemStack> list = OreDictionary.getOres("bamboo");
            for (ItemStack item : list)
            {
                OreDictionary.registerOre("vegetableBambooShoot", item);
            }
        }
        catch (Exception e)
        {
            TofuFactory.tfLog.warn("Failed to access BambooMod's items", e);
        }
    }
}
