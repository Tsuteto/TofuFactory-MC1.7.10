package tofufactory.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.plugin.PluginTofuFactory;
import tsuteto.tofu.item.ItemTcMaterials;
import tsuteto.tofu.item.TcItems;

public class RecipeManagerTofuFactory
{
    public static void registerRecipes()
    {
        registeCrafting();
        registeSmelting();
        registePulverizer();
        registeCompactor();
        registeCuttingMachine();
    }

    private static void registeCrafting()
    {
        GameRegistry.addRecipe(new ItemStack(PluginTofuFactory.zundaSword, 1),
                "x",
                "x",
                "y",
                'x', PluginTofuFactory.zundaIngot,
                'y', Items.stick);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuDust, 1, 0),
                "xyx",
                'y', new ItemStack(TcItems.materials, 1, 1),
                'x', Items.flint));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuPulverizerIdle, 1),
                "xxx",
                "z z",
                "yay",
                'x', "plateMithril",
                'y', "gearDiamondTofu",
                'z', Items.flint,
                'a', "craftingCircuitTier02"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuCompactorIdle, 1),
                "xxx",
                "z z",
                "yay",
                'x', "plateMithril",
                'y', "gearDiamondTofu",
                'z', Blocks.stone,
                'a', "craftingCircuitTier02"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuCuttingMachineIdle, 1),
                "xxx",
                "z z",
                "yay",
                'x', "plateMithril",
                'y', "gearDiamondTofu",
                'z', "craftingDiamondBlade",
                'a', "craftingCircuitTier02"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.cake, 1),
                "xxx",
                "yzy",
                "aaa",
                'x', Items.milk_bucket,
                'y', Items.sugar,
                'z', Items.egg,
                'a', "cookingFlour"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(PluginTofuFactory.tofuDust, 2, 2),
                "dustMithril", "dustGold"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(PluginTofuFactory.tofuDust, 2, 3),
                "dustMithril", "dustSilver"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(PluginTofuFactory.tofuMaterial, 1, 0),
                "ingotSol", Items.redstone));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(PluginTofuFactory.tofuMaterial, 1, 1),
                "ingotLuna", "dustDiamondTofu"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuMaterial, 1, 4),
                " x ",
                "xyx",
                " x ",
                'x', "dustLuna",
                'y', "gearDiamondTofu"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuMaterial, 2, 2),
                "xxx",
                "x x",
                "xxx",
                'x', "ingotSol"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(PluginTofuFactory.tofuMaterial, 2, 3),
                "xxx",
                "x x",
                "xxx",
                'x', "ingotLuna"));
    }

    private static void registeSmelting()
    {
        GameRegistry.addSmelting(new ItemStack(PluginTofuFactory.tofuDust, 1, 0), new ItemStack(PluginTofuFactory.tofuIngot, 1, 0), 1.5F);
        GameRegistry.addSmelting(PluginTofuFactory.oreMithril, new ItemStack(PluginTofuFactory.tofuIngot, 1, 1), 1.5F);
        GameRegistry.addSmelting(PluginTofuFactory.flour, new ItemStack(Items.bread, 1, 0), 1.5F);
    }

    private static void registePulverizer()
    {
        RecipeManagers.pulverizerManager.addRecipe(
                new ItemStack(TcItems.materials, 1, 1), new ItemStack(PluginTofuFactory.tofuDust, 2, 0));
        RecipeManagers.pulverizerManager.addRecipe(
                new ItemStack(Items.wheat, 1), new ItemStack(PluginTofuFactory.flour, 2, 0));
    }

    private static void registeCompactor() {}

    private static void registeCuttingMachine()
    {
        RecipeManagers.cuttingMachineManager.addRecipe(
                TcItems.materials.getItemStack(ItemTcMaterials.tofuDiamondNugget),
                new ItemStack(PluginTofuFactory.tofuDust, 2, 0));
    }
}
