package tofufactory.plugin;

import appeng.api.AEApi;
import appeng.api.definitions.Materials;
import net.minecraftforge.oredict.OreDictionary;

public class PluginAppeng
{
    public static void Init()
    {
        registeOreDictionary();
    }

    public static void registeOreDictionary()
    {
        Materials materials = AEApi.instance().materials();
        OreDictionary.registerOre("flour", materials.materialFlour.stack(1));
        OreDictionary.registerOre("cookingFlour", materials.materialFlour.stack(1));
        OreDictionary.registerOre("craftingCircuitTier04", materials.materialBasicCard.stack(1)); // materialProcessorBasic
        OreDictionary.registerOre("craftingCircuitTier05", materials.materialAdvCard.stack(1)); // materialProcessorAdvanced
    }
}
