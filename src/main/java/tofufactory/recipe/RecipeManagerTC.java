package tofufactory.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import tofufactory.plugin.PluginTC;
import tofufactory.plugin.PluginTofuFactory;
import tsuteto.tofu.block.TcBlocks;
import tsuteto.tofu.item.TcItems;

public class RecipeManagerTC
{
    public static final String tofuKinuK = "ArcaneKinuTofu";
    public static final String tofuFocusK = "tofuFocus";
    public static final String MagicCircuitK = "MagicCircuit";
    public static final String MithrilK = "Mithril";
    public static final String SolK = "Sol";
    public static final String LunaK = "Luna";

    public static ShapelessArcaneRecipe tofuKinuR;
    public static ShapelessArcaneRecipe tofuFocusR;
    public static ShapelessArcaneRecipe MagicCircuitR;
    public static CrucibleRecipe MithrilR;
    public static CrucibleRecipe SolR;
    public static CrucibleRecipe LunaR;

    public static void registerRecipes()
    {
        registArcaneCrafting();
        InitResearch();
    }

    private static void registArcaneCrafting()
    {
        // Tofu study
        tofuKinuR = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                tofuKinuK,
                new ItemStack(TcBlocks.tofuKinu, 1),
                (new AspectList()).add(Aspect.WATER, 2),
                new ItemStack(TcItems.bucketSoymilk, 1));

        // Tofu Focus
        tofuFocusR = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                tofuKinuK,
                new ItemStack(PluginTC.tofuFocus, 1),
                (new AspectList()).add(Aspect.WATER, 2),
                new ItemStack(TcBlocks.tofuKinu, 1));

        // Magic Circuit
        MagicCircuitR = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                MagicCircuitK,
                new ItemStack(PluginTofuFactory.tofuMaterial, 4, 0),
                (new AspectList()).add(Aspect.EARTH, 3),
                new ItemStack(PluginTofuFactory.tofuIngot, 1, 2),
                new ItemStack(Items.redstone, 1));

        // Mithril
        MithrilR = ThaumcraftApi.addCrucibleRecipe(
                MithrilK,
                new ItemStack(PluginTofuFactory.tofuIngot, 2, 1), "ingotIron",
                (new AspectList()).add(PluginTC.TOFU, 2));

        //
        SolR = ThaumcraftApi.addCrucibleRecipe(
                SolK,
                new ItemStack(PluginTofuFactory.tofuIngot, 2, 2), "ingotMithril",
                (new AspectList()).add(PluginTC.TOFU, 1).add(Aspect.LIGHT, 1));
        LunaR = ThaumcraftApi.addCrucibleRecipe(
                LunaK,
                new ItemStack(PluginTofuFactory.tofuIngot, 2, 3), "ingotMithril",
                (new AspectList()).add(PluginTC.TOFU, 1).add(Aspect.WEATHER, 1));
    }

    public static void InitResearch()
    {
        ResearchCategories.addResearch((new ResearchItem("TofuAspect", PluginTC.ResearchTOFU, null, 0, 0, 1,
                new ResourceLocation("thaumcraft", "textures/aspects/terra.png")))
                .setPages(new ResearchPage("TofuAspect", "tc.research_page.TofuAspect"),
                        new ResearchPage((new AspectList()).add(PluginTC.TOFU, 1)))
                .setAutoUnlock().setRound());

        ResearchCategories.addResearch((new ResearchItem(tofuKinuK, PluginTC.ResearchTOFU,
                (new AspectList()).add(PluginTC.TOFU, 1), -2, 0, 1, new ItemStack(TcBlocks.tofuKinu, 1)))
                .setPages(new ResearchPage(tofuKinuK, "tc.research_page." + tofuKinuK),
                        new ResearchPage(tofuKinuR)).setParents("TofuAspect"));

        ResearchCategories.addResearch((new ResearchItem(tofuFocusK, PluginTC.ResearchTOFU,
                (new AspectList()).add(PluginTC.TOFU, 1), -1, 2, 1, new ItemStack(PluginTC.tofuFocus, 1)))
                .setPages(new ResearchPage(tofuFocusK, "tc.research_page." + tofuFocusK),
                        new ResearchPage(tofuFocusR)).setParents(new String[] {"TofuAspect"}).setSpecial());

        ResearchCategories.addResearch((new ResearchItem(MithrilK, PluginTC.ResearchTOFU,
                (new AspectList()).add(PluginTC.TOFU, 1), 2, -1, 1, new ItemStack(PluginTofuFactory.tofuIngot, 1, 1)))
                .setPages(new ResearchPage(MithrilK, "tc.research_page." + MithrilK),
                        new ResearchPage(MithrilR)).setParents("TofuAspect").setSiblings(SolK, LunaK).setRound());

        ResearchCategories.addResearch((new ResearchItem(SolK, PluginTC.ResearchTOFU,
                (new AspectList()).add(PluginTC.TOFU, 1), 4, 0, 1, new ItemStack(PluginTofuFactory.tofuIngot, 4, 2)))
                .setPages(new ResearchPage(SolK, "tc.research_page." + SolK),
                        new ResearchPage(SolR)).setParents(MithrilK));

        ResearchCategories.addResearch((new ResearchItem(LunaK, PluginTC.ResearchTOFU,
                (new AspectList()).add(PluginTC.TOFU, 1), 4, -2, 1, new ItemStack(PluginTofuFactory.tofuIngot, 4, 3)))
                .setPages(new ResearchPage(LunaK, "tc.research_page." + LunaK),
                        new ResearchPage(LunaR))
                .setParents(MithrilK));

        ResearchCategories.addResearch((new ResearchItem(MagicCircuitK, PluginTC.ResearchTOFU,
                (new AspectList()).add(PluginTC.TOFU, 1), 2, 2, 1, new ItemStack(PluginTofuFactory.tofuMaterial, 4, 0)))
                .setPages(new ResearchPage(MagicCircuitK, "tc.research_page." + MagicCircuitK),
                        new ResearchPage(MagicCircuitR)).setSpecial());
    }
}
