package tofufactory.machinerecipe;

import net.minecraft.item.ItemStack;
import tofufactory.TFPluginManager;
import tofufactory.api.recipes.IPulverizerManager;
import tofufactory.config.TFConfig;
import tofufactory.recipe.RecipeManagerIC2;

public class PulverizerRecipe extends SimpleTofuMachineRecipe implements IPulverizerManager
{

    public ItemStack getProcessingResult(ItemStack input)
    {
        if (input == null)
        {
            return null;
        }
        else
        {
            ItemStack ret = this.getResultFromMetaItem(input);

            if (ret != null)
            {
                return getOreDictStack(ret);
            }
            else
            {
                ItemStack re2 = this.getResultFromItem(input);

                if (re2 != null)
                {
                    return getOreDictStack(re2);
                }
                else if (TFPluginManager.modIC2 && TFConfig.IC2)
                {
                    ItemStack inItem = input.copy();
                    ItemStack re3 = RecipeManagerIC2.getMaceratorResult(inItem);
                    return re3 != null ? getOreDictStack(re3) : null;
                }
                else
                {
                    return null;
                }
            }
        }
    }
}
