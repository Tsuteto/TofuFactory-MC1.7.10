package tofufactory.plugin;

import ic2.api.crops.CropCard;
import net.minecraft.item.ItemStack;
import tofufactory.TFPluginManager;
import tofufactory.config.TFConfig;

// I seal down Greg features for now (╯•﹏•╰)
public class PluginGreg
{
    public static CropCard daizu;

    public static void Init()
    {
        registeOreDictionaryGreg();
    }

    public static void registeOreDictionaryGreg()
    {
        if (TFPluginManager.modGT && TFConfig.Greg)
        {
            //OreDictionary.registerOre("cookingFlour", new ItemStack(GregTech_API., 1, 14));
        }
    }

    public static ItemStack getOreDictStack(ItemStack aOreStack)
    {
        return null; //GregTech_API.getUnificatedOreDictStack(aOreStack);
    }
}
