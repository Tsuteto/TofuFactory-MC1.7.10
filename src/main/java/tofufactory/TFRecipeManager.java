package tofufactory;

import tofufactory.config.TFConfig;
import tofufactory.recipe.*;

public class TFRecipeManager
{
    public static void registerRecipes()
    {
        RecipeManagerTofuFactory.registerRecipes();

        RecipeManagerBC.registerRecipes();

        if (TFPluginManager.modIC2 && TFConfig.IC2)
        {
            RecipeManagerIC2.registerRecipes();
        }

        if (TFPluginManager.modForestry && TFConfig.Forestry)
        {
            RecipeManagerFFM.registerRecipes();
        }

        if (TFPluginManager.modGT && TFConfig.Greg)
        {
            RecipeManagerGreg.registerRecipes();
        }

        if (TFPluginManager.modTConstruct && TFConfig.Tcon)
        {
            RecipeManagerTcon.registerRecipes();
        }

        if (TFPluginManager.modTC && TFConfig.ThaumCraft)
        {
            RecipeManagerTC.registerRecipes();
        }
    }
}
