package tofufactory.api.recipes;

import net.minecraft.item.ItemStack;

public interface IMachineRecipe
{
    ItemStack getProcessingResult(ItemStack var1);
}
