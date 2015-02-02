package tofufactory.machinerecipe;

import net.minecraft.item.ItemStack;
import tofufactory.TFPluginManager;
import tofufactory.api.recipes.ICompactorManager;
import tofufactory.config.TFConfig;
import tofufactory.recipe.RecipeManagerIC2;

public class CompactorRecipe extends SimpleTofuMachineRecipe implements ICompactorManager
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
                else
                {
                    if (TFPluginManager.modIC2 && TFConfig.IC2)
                    {
                        ItemStack re3 = RecipeManagerIC2.getCompresserResult(input.copy());

                        if (re3 != null)
                        {
                            return getOreDictStack(re3);
                        }
                    }

                    return null;
                }
            }
        }
    }
}
