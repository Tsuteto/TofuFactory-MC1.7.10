package tofufactory.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.Smeltery;
import tofufactory.fluid.TFFluids;
import tofufactory.plugin.PluginTofuFactory;
import tsuteto.tofu.block.TcBlocks;
import tsuteto.tofu.item.TcItems;

public class RecipeManagerTcon
{
    public static void registerRecipes()
    {
        Smeltery.addMelting(new ItemStack(TcItems.zunda, 1), TcBlocks.tofuZunda, 0, 100,
                new FluidStack(TFFluids.zunda, 1000));
        ItemStack ingotcast = new ItemStack(TConstructRegistry.getItem("metalPattern"), 1, 0);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                new ItemStack(PluginTofuFactory.zundaIngot, 1), new FluidStack(TFFluids.moltenZundaFluid, 1000), ingotcast, 80);

        // Somehow Smeltery can't smelt iron ingots
        FluidStack Iron = Smeltery.getSmelteryResult(new ItemStack(Blocks.iron_ore));
        Smeltery.addAlloyMixing(new FluidStack(TFFluids.moltenZundaFluid, 24), new FluidStack(Iron, 16), new FluidStack(TFFluids.zunda, 8));
    }
}
