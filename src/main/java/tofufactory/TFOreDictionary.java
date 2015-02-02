package tofufactory;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tofufactory.plugin.PluginTofuFactory;
import tsuteto.tofu.item.TcItems;

public class TFOreDictionary
{
    public static void registeOreDictionary()
    {
        OreDictionary.registerOre("ingotTofuMetal", TcItems.tofuMetal);
        OreDictionary.registerOre("vegetableLeek", TcItems.leek);
        OreDictionary.registerOre("cookingFlour", PluginTofuFactory.flour);
        OreDictionary.registerOre("craftingMacerator", new ItemStack(PluginTofuFactory.tofuPulverizerIdle, 1, 0));
        OreDictionary.registerOre("craftingCompressor", new ItemStack(PluginTofuFactory.tofuCompactorIdle, 1, 0));
        OreDictionary.registerOre("craftingDiamondBlade", new ItemStack(PluginTofuFactory.tofuMaterial, 1, 4));
        OreDictionary.registerOre("craftingHeatingCoilTier00", new ItemStack(PluginTofuFactory.tofuMaterial, 1, 2));
        OreDictionary.registerOre("craftingHeatingCoilTier01", new ItemStack(PluginTofuFactory.tofuMaterial, 1, 3));
        OreDictionary.registerOre("craftingCircuitTier02", new ItemStack(PluginTofuFactory.tofuMaterial, 1, 0));
        OreDictionary.registerOre("craftingCircuitTier04", new ItemStack(PluginTofuFactory.tofuMaterial, 1, 1));
    }
}
