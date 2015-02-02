package tofufactory.recipe;

import buildcraft.BuildCraftTransport;
import buildcraft.core.recipes.RefineryRecipeManager;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tofufactory.TofuFactory;
import tofufactory.fluid.TFFluids;
import tofufactory.plugin.PluginBC;
import tofufactory.plugin.PluginTofuFactory;
import tsuteto.tofu.fluids.TcFluids;
import tsuteto.tofu.item.TcItems;

public class RecipeManagerBC
{
    public static void registerRecipes()
    {
        // Refinery Recipes
        RefineryRecipeManager.INSTANCE.addRecipe(TofuFactory.resourceDomain + "noodleSoup", new FluidStack(TFFluids.soupStock, 500), new FluidStack(TcFluids.SOY_SAUCE, 1000), new FluidStack(TFFluids.noodleSoup, 1500), 20, 30);

        // Crafting Recipes
        GameRegistry.addRecipe(new ItemStack(PluginBC.pipeItemsTofuIshi, 8),
                "zxz",
                'z', TcItems.tofuIshi,
                'x', Blocks.glass);

        GameRegistry.addShapelessRecipe(new ItemStack(PluginBC.pipeFluidsTofuIshi, 1),
                new ItemStack(PluginBC.pipeItemsTofuIshi, 1),
                new ItemStack(BuildCraftTransport.pipeWaterproof, 1));

        GameRegistry.addShapelessRecipe(new ItemStack(PluginBC.pipePowerTofuIshi, 1),
                new ItemStack(PluginBC.pipeItemsTofuIshi, 1),
                new ItemStack(Items.redstone, 1));

        GameRegistry.addRecipe(new ItemStack(PluginBC.pipeItemsZunda, 8),
                "zxz",
                'z', PluginTofuFactory.zundaIngot,
                'x', Blocks.glass);

        GameRegistry.addShapelessRecipe(new ItemStack(PluginBC.pipeFluidsZunda, 1),
                new ItemStack(PluginBC.pipeItemsZunda, 1),
                new ItemStack(BuildCraftTransport.pipeWaterproof, 1));

        GameRegistry.addShapelessRecipe(new ItemStack(PluginBC.pipePowerZunda, 1),
                new ItemStack(PluginBC.pipeItemsZunda, 1),
                new ItemStack(Items.redstone, 1));


    }
}
