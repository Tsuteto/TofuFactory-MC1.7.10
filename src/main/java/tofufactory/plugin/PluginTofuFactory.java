package tofufactory.plugin;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.block.BlockTofuCompactor;
import tofufactory.block.BlockTofuCuttingMachine;
import tofufactory.block.BlockTofuFactory;
import tofufactory.block.BlockTofuPulverizer;
import tofufactory.item.*;
import tofufactory.registry.BlockRegister;
import tofufactory.registry.ItemRegister;
import tofufactory.tileEntity.TileEntityTofuCompactor;
import tofufactory.tileEntity.TileEntityTofuCuttingMachine;
import tofufactory.tileEntity.TileEntityTofuPulverizer;
import tsuteto.tofu.util.Utils;

public class PluginTofuFactory
{
    public static final String[] TFName = new String[] {"diamondTofu", "mithril", "sol", "luna"};

    public static Item.ToolMaterial ZUNDA;
    public static Item zundaSword;
    public static Item zundaIngot;
    public static Item tofuMaterial;
    public static Item tofuDust;
    public static Item tofuGear;
    public static Item tofuIngot;
    public static Item tofuPlate;
    public static Item tofuGem;
    public static Item flour;
    public static Item bakingSoda;
    public static Item udonNoodles;
    public static Item ramenNoodles;
    public static Item kamaboko;
    public static Block oreMithril;
    public static Block tofuPulverizerIdle;
    public static Block tofuPulverizerActive;
    public static Block tofuCompactorIdle;
    public static Block tofuCompactorActive;
    public static Block tofuCuttingMachineIdle;
    public static Block tofuCuttingMachineActive;

    public static void Init()
    {
        initItem();
        initTofuMaterial();
        initTofuDust();
        initTofuIngot();
        initTofuPlate();
        initTofuGem();
        initTofuGear();
    }

    private static void initItem()
    {
        ZUNDA = EnumHelper.addToolMaterial("ZUNDA", 2, 415, 6.0F, 2.0F, 8);
        zundaSword = ItemRegister.of("zundaSword", new ItemZundaSword(ZUNDA)).register();
        zundaIngot = ItemRegister.of("zundaIngot", new ItemTofuFactory()).register();

        flour = ItemRegister.of("flour", new ItemTofuFactory()).register();
        bakingSoda = ItemRegister.of("bakingSoda", new ItemTofuFactory()).register();
        udonNoodles = ItemRegister.of("udon", new ItemTofuFactory()).register();
        ramenNoodles = ItemRegister.of("ramen", new ItemTofuFactory()).register();
        kamaboko = ItemRegister.of("kamaboko", new ItemTofuFactory()).register();

        oreMithril = BlockRegister.of("oreMithril", new BlockTofuFactory(Material.rock)).register()
                .setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone);

        tofuPulverizerIdle = BlockRegister.of("Pulverizer", new BlockTofuPulverizer(false))
                .withResource("tfPulverizer")
                .register()
                .setBlockTextureName("Pulverizer")
                .setHardness(3.5F).setStepSound(Block.soundTypeStone);
        tofuPulverizerActive = BlockRegister.of("PulverizerActive", new BlockTofuPulverizer(true))
                .withResource("tfPulverizer")
                .register()
                .setBlockTextureName("Pulverizer")
                .setHardness(3.5F).setStepSound(Block.soundTypeStone);
        tofuCompactorIdle = BlockRegister.of("Compactor", new BlockTofuCompactor(false))
                .withResource("tfCompactor")
                .register()
                .setBlockTextureName("Compactor")
                .setHardness(3.5F).setStepSound(Block.soundTypeStone);
        tofuCompactorActive = BlockRegister.of("CompactorActive", new BlockTofuCompactor(true))
                .withResource("tfCompactor")
                .register()
                .setBlockTextureName("Compactor")
                .setHardness(3.5F).setStepSound(Block.soundTypeStone);
        tofuCuttingMachineIdle = BlockRegister.of("CuttingMachine", new BlockTofuCuttingMachine(false))
                .withResource("tfCuttingMachine")
                .register()
                .setBlockTextureName("CuttingMachine")
                .setHardness(3.5F).setStepSound(Block.soundTypeStone);
        tofuCuttingMachineActive = BlockRegister.of("CuttingMachineActive", new BlockTofuCuttingMachine(true))
                .withResource("tfCuttingMachine")
                .register()
                .setBlockTextureName("CuttingMachine")
                .setHardness(3.5F).setStepSound(Block.soundTypeStone);

        GameRegistry.registerTileEntity(TileEntityTofuPulverizer.class, "TfPulverizer");
        GameRegistry.registerTileEntity(TileEntityTofuCompactor.class, "TfCompactor");
        GameRegistry.registerTileEntity(TileEntityTofuCuttingMachine.class, "TfCuttingMachine");

        OreDictionary.registerOre("oreMithril", oreMithril);
    }

    private static void initTofuMaterial()
    {
        String[] tofuMaterialName = new String[] {"magicCircuit", "magicCircuitAdv", "ringSun", "ringMoon", "tofuBlade"};
        tofuMaterial = ItemRegister.of("TofuMaterial",  new ItemTFMaterial(tofuMaterialName)).register();
    }

    private static void initTofuDust()
    {
        tofuDust = ItemRegister.of("tofuDust",  new ItemTFDust(TFName)).register();

        for (int i = 0; i < TFName.length; ++i)
        {
            OreDictionary.registerOre(getOreDicName("dust", TFName[i]), new ItemStack(tofuDust, 1, i));
        }
    }

    private static void initTofuIngot()
    {
        tofuIngot = ItemRegister.of("tofuIngot", new ItemTofuIngot(TFName)).register();

        for (int i = 0; i < TFName.length; ++i)
        {
            OreDictionary.registerOre(getOreDicName("ingot", TFName[i]), new ItemStack(tofuIngot, 1, i));
            GameRegistry.addSmelting(new ItemStack(tofuDust, 1, i), new ItemStack(tofuIngot, 1, i), 1.5F);
            RecipeManagers.pulverizerManager.addRecipe(new ItemStack(tofuIngot, 1, i), new ItemStack(tofuDust, 1, i));
        }
    }

    private static void initTofuPlate()
    {
        tofuPlate = ItemRegister.of("tofuPlate", new ItemTofuPlate(TFName)).register();

        for (int i = 0; i < TFName.length; ++i)
        {
            OreDictionary.registerOre(getOreDicName("plate", TFName[i]), new ItemStack(tofuPlate, 1, i));
            GameRegistry.addSmelting(new ItemStack(tofuIngot, 1, i), new ItemStack(tofuPlate, 1, i), 1.5F);
            RecipeManagers.compactorManager.addRecipe(new ItemStack(tofuIngot, 1, i), new ItemStack(tofuPlate, 1, i));
        }
    }

    private static void initTofuGear()
    {
        tofuGear = ItemRegister.of("tofuGear", new ItemTofuGear(TFName)).register();
        int i;

        for (i = 0; i < TFName.length; ++i)
        {
            OreDictionary.registerOre(getOreDicName("gear", TFName[i]), new ItemStack(tofuGear, 1, i));
        }

        for (i = 0; i < TFName.length; ++i)
        {
            GameRegistry.addRecipe(new ItemStack(tofuGear, 1, i),
                    " x ",
                    "x x",
                    " x ",
                    'x', new ItemStack(tofuIngot, 1, i));
        }
    }

    private static void initTofuGem()
    {
        String[] tofuGemName = new String[] {"emerald", "peridot", "ruby", "sapphire", "sugilite", "topaz"};
        tofuGem = ItemRegister.of("tofuGem",  new ItemTofuGem(tofuGemName)).register();

        for (int i = 0; i < tofuGemName.length; ++i)
        {
            OreDictionary.registerOre(getOreDicName("gem", tofuGemName[i]), new ItemStack(tofuGem, 1, i));
        }
    }

    private static String getOreDicName(String prefix, String name)
    {
        return prefix + Utils.capitalize(name);
    }
}
