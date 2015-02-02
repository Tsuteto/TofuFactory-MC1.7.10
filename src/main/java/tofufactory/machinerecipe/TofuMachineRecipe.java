package tofufactory.machinerecipe;

import net.minecraft.item.ItemStack;
import tofufactory.TFPluginManager;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.config.TFConfig;
import tofufactory.plugin.PluginGreg;

public class TofuMachineRecipe
{
    public static void initRecipe()
    {
        RecipeManagers.pulverizerManager = new PulverizerRecipe();
        RecipeManagers.compactorManager = new CompactorRecipe();
        RecipeManagers.cuttingMachineManager = new CuttingMachineManager();
    }

    public static ItemStack getOreDictStack(ItemStack aOreStack)
    {
        return TFPluginManager.modGT && TFConfig.Greg ? PluginGreg.getOreDictStack(aOreStack.copy()) : aOreStack;
    }


}
