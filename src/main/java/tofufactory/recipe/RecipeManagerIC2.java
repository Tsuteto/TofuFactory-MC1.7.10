package tofufactory.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import tofufactory.plugin.PluginIC2;
import tofufactory.plugin.PluginTofuFactory;

public class RecipeManagerIC2
{
    public static void registerRecipes()
    {
        registeCrafting();
        registeMacerator();
        registeCompresser();
    }

    private static void registeCrafting()
    {
        // BatBox recipe
        GameRegistry.addRecipe(new ShapedOreRecipe(IC2Items.getItem("batBox"),
                "xyx",
                "xzx",
                "xxx",
                'y', PluginTofuFactory.zundaIngot,
                'z', new ItemStack(PluginIC2.zundaBattery, 1, 32767),
                'x', "plankWood"));
    }

    private static void registeMacerator() {}

    private static void registeCompresser() {}

    public static ItemStack getMaceratorResult(ItemStack input)
    {
        return Recipes.macerator.getOutputFor(input.copy(), true) == null ? null
                : (Recipes.macerator.getOutputFor(input.copy(), true).items == null ? null
                : Recipes.macerator.getOutputFor(input.copy(), true).items.get(0));
    }

    public static ItemStack getCompresserResult(ItemStack input)
    {
        return Recipes.compressor.getOutputFor(input.copy(), true) == null ? null
                : (Recipes.compressor.getOutputFor(input.copy(), true).items == null ? null
                : Recipes.compressor.getOutputFor(input.copy(), true).items.get(0));
    }
}
