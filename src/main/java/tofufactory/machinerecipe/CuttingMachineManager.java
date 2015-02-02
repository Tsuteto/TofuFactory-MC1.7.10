package tofufactory.machinerecipe;

import net.minecraft.item.ItemStack;
import tofufactory.api.recipes.ICuttingMachineManager;

public class CuttingMachineManager extends SimpleTofuMachineRecipe implements ICuttingMachineManager
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
                return re2 != null ? getOreDictStack(re2) : null;
            }
        }
    }
}
