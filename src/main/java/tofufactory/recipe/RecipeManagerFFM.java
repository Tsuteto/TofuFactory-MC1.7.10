package tofufactory.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.recipes.RecipeManagers;
import forestry.core.config.ForestryItem;
import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import tofufactory.TFPluginManager;
import tofufactory.fluid.TFFluids;
import tofufactory.plugin.PluginFFM;
import tofufactory.plugin.PluginTofuFactory;
import tsuteto.tofu.block.TcBlocks;
import tsuteto.tofu.fluids.TcFluids;
import tsuteto.tofu.item.ItemTcMaterials;
import tsuteto.tofu.item.TcItems;

public class RecipeManagerFFM
{
    public static void registerRecipes()
    {
        registerForCrafting();
        registerInCarpenter();
        registerInFabricator();
        registerInSqueezer();
        registerInStill();
    }

    private static void registerInFabricator()
    {
        // Zunda Tube
        RecipeManagers.fabricatorManager.addRecipe(
                null, FluidRegistry.getFluidStack("glass", 500), new ItemStack(PluginFFM.TFTube, 4, 0),
                new Object[]{
                        " X ",
                        "#X#",
                        "XXX",
                        '#', Items.redstone,
                        'X', PluginTofuFactory.zundaIngot});
        // Tofu Gem Tube
        RecipeManagers.fabricatorManager.addRecipe(
                null, FluidRegistry.getFluidStack("glass", 500), new ItemStack(PluginFFM.TFTube, 4, 1),
                new Object[]{
                        " X ",
                        "#X#",
                        "XXX",
                        '#', Items.redstone,
                        'X', TcItems.materials.getItemStack(ItemTcMaterials.tofuGem)});
        // Ishi Tofu Tube
        RecipeManagers.fabricatorManager.addRecipe(
                null, FluidRegistry.getFluidStack("glass", 500), new ItemStack(PluginFFM.TFTube, 4, 2),
                new Object[]{
                        " X ",
                        "#X#",
                        "XXX",
                        '#', Items.redstone,
                        'X', TcBlocks.tofuIshi});
        // Metal Tofu Tube
        RecipeManagers.fabricatorManager.addRecipe(
                null, FluidRegistry.getFluidStack("glass", 500), new ItemStack(PluginFFM.TFTube, 4, 3),
                new Object[]{
                        " X ",
                        "#X#",
                        "XXX",
                        '#', Items.redstone,
                        'X', TcBlocks.tofuMetal});
    }

    private static void registerForCrafting()
    {
        // Backpacks
        GameRegistry.addRecipe(new ItemStack(PluginFFM.tofuBackpackT1, 1),
                "yxy",
                "zsz",
                "yxy",
                'z', TcItems.tofuKinu,
                'x', Blocks.wool,
                'y', Items.string,
                's', Blocks.chest);

        ItemStack inputItem = ForestryItem.craftingMaterial.getItemStack();
        inputItem.setItemDamage(3);
        RecipeManagers.carpenterManager.addRecipe(200, new FluidStack(FluidRegistry.WATER, 1000), null,
                new ItemStack(PluginFFM.tofuBackpackT2),
                "wxw",
                "wyw",
                "www",
                'w', inputItem,
                'x', Items.diamond,
                'y', PluginFFM.tofuBackpackT1);

        GameRegistry.addRecipe(new ItemStack(PluginFFM.zundaBackpackT1, 1),
                "yxy",
                "zsz",
                "yxy",
                'z', PluginTofuFactory.zundaIngot,
                'x', Blocks.wool,
                'y', Items.string,
                's', Blocks.chest);

        RecipeManagers.carpenterManager.addRecipe(200, new FluidStack(FluidRegistry.WATER, 1000), null,
                new ItemStack(PluginFFM.zundaBackpackT2),
                "wxw",
                "wyw",
                "www",
                'w', inputItem,
                'x', Items.diamond,
                'y', PluginFFM.zundaBackpackT1);

        // Grafter
        GameRegistry.addRecipe(new ItemStack(PluginFFM.zundaGrafter, 1),
                "  x",
                " y ",
                "y  ",
                'x', PluginTofuFactory.zundaIngot,
                'y', Items.stick);
    }

    private static void registerInCarpenter()
    {
        if (TFPluginManager.modIC2)
        {
            registerUsingIC2();
        }

        RecipeManagers.carpenterManager.addRecipe(20, (FluidStack)null, null,
                new ItemStack(PluginTofuFactory.flour, 4),
                "x",
                'x', Items.wheat);
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.WATER, 500), null,
                new ItemStack(PluginTofuFactory.udonNoodles, 2),
                "yxy",
                'x', PluginTofuFactory.flour,
                'y', "starch");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.WATER, 500), null,
                new ItemStack(PluginTofuFactory.ramenNoodles, 2),
                "yxy",
                'x', PluginTofuFactory.flour,
                'y', PluginTofuFactory.bakingSoda);
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.LAVA, 200), null,
                new ItemStack(Items.iron_ingot, 3),
                "x",
                'x', "oreIron");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.LAVA, 200), null,
                new ItemStack(Items.gold_ingot, 3),
                "x",
                'x', "oreGold");

        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.LAVA, 200), null,
                ForestryItem.ingotCopper.getItemStack(3),
                "x",
                'x', "oreCopper");

        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(FluidRegistry.LAVA, 200), null,
                ForestryItem.ingotTin.getItemStack(3),
                "x",
                'x', "oreTin");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TFFluids.zunda, 500), null,
                new ItemStack(PluginTofuFactory.zundaIngot, 1),
                "x",
                'x', Items.iron_ingot);
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TFFluids.drinkingWater, 500), new ItemStack(Blocks.wooden_slab, 1),
                new ItemStack(PluginTofuFactory.kamaboko, 1),
                "x",
                'x', Items.fish);
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TcFluids.SOY_SAUCE, 100), new ItemStack(Items.bowl, 1),
                new ItemStack(TcItems.nattoHiyayakko, 1),
                "x",
                "y",
                "z",
                'x', "vegetableLeek",
                'y', "natto",
                'z', "tofuKinu");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TFFluids.soupStock, 500),
                new ItemStack(Items.bowl, 1), new ItemStack(TcItems.misoSoup, 1),
                "x",
                "y",
                'x', "miso",
                'y', "tofuKinu");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TFFluids.soupStock, 500),
                null, new ItemStack(TcItems.fukumeni, 1),
                "x",
                "y",
                'x', "salt",
                'y', "tofuDried");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TFFluids.soupStock, 500),
                null, new ItemStack(TcItems.tofuSesame, 1),
                "x",
                "y",
                "z",
                'x', "salt",
                'y', "starch",
                'z', "sesame");
        RecipeManagers.carpenterManager.addRecipe(20, new FluidStack(TFFluids.noodleSoup, 500),
                new ItemStack(Items.bowl, 1), new ItemStack(TcItems.agedashiTofu, 1),
                "x",
                'x', "tofuFriedPouch");
    }

    public static void registerUsingIC2()
    {
        ItemStack electronicCircuit = IC2Items.getItem("electronicCircuit");
        electronicCircuit.stackSize = 3;
        RecipeManagers.carpenterManager.addRecipe(14, new FluidStack(TFFluids.drinkingWater, 200),
                null, electronicCircuit,
                "xxx",
                "yzy",
                "xxx",
                'x', IC2Items.getItem("insulatedCopperCableItem"),
                'y', Items.redstone,
                'z', Items.iron_ingot);

        ItemStack advancedCircuit = IC2Items.getItem("advancedCircuit");
        advancedCircuit.stackSize = 2;
        RecipeManagers.carpenterManager.addRecipe(14, new FluidStack(TFFluids.drinkingWater, 200),
                null, advancedCircuit,
                "xax",
                "yzy",
                "xax",
                'x', IC2Items.getItem("insulatedCopperCableItem"),
                'y', "ingotDiamondTofu",
                'z', Items.redstone,
                'a', Items.glowstone_dust);
    }

    private static void registerInSqueezer()
    {
        ItemStack[] myFish = new ItemStack[] {new ItemStack(Items.cooked_fished, 1)};
        ItemStack[] myTofu = new ItemStack[] {new ItemStack(TcItems.soybeans, 1)};
        ItemStack[] myZunda = new ItemStack[] {new ItemStack(TcItems.zunda, 1)};

        RecipeManagers.squeezerManager.addRecipe(30, myFish,
                new FluidStack(TFFluids.soupStock, 500), new ItemStack(Items.bone, 1), 50);
        RecipeManagers.squeezerManager.addRecipe(20, myTofu,
                new FluidStack(TcFluids.SOYMILK, 1000), new ItemStack(TcItems.okara, 2), 80);
        RecipeManagers.squeezerManager.addRecipe(20, myZunda,
                new FluidStack(TFFluids.zunda, 500), null, 0);
    }

    private static void registerInStill()
    {
        RecipeManagers.stillManager.addRecipe(10, new FluidStack(FluidRegistry.WATER, 10),
                new FluidStack(TFFluids.drinkingWater, 10));
    }
}
