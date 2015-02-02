package tofufactory.plugin;

import com.google.common.collect.Lists;
import cpw.mods.fml.common.event.FMLInterModComms;
import forestry.api.storage.BackpackManager;
import forestry.api.storage.EnumBackpackType;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import tofufactory.TFPluginManager;
import tofufactory.TofuFactory;
import tofufactory.bee.BeeManager;
import tofufactory.bee.TFHiveType;
import tofufactory.block.BlockTFHive;
import tofufactory.config.TFConfig;
import tofufactory.ffm.farming.TFFarmingRegister;
import tofufactory.item.ItemTFGrafter;
import tofufactory.item.ItemTube;
import tofufactory.item.ItemTubeOverlayInfo;
import tofufactory.registry.BlockRegister;
import tofufactory.registry.ItemRegister;
import tofufactory.storage.BackpackDefinition;
import tsuteto.tofu.block.TcBlocks;
import tsuteto.tofu.item.ItemFoodSet;
import tsuteto.tofu.item.ItemTcMaterials;
import tsuteto.tofu.item.TcItems;

import java.util.ArrayList;

public class PluginFFM
{
    public static Item tofuBackpackT1;
    public static Item tofuBackpackT2;
    public static Item zundaBackpackT1;
    public static Item zundaBackpackT2;
    public static Item TFTube;
    public static Item zundaGrafter;
    public static Block tofuHive;
    public static ArrayList<ItemStack> tofuItems = Lists.newArrayList();
    public static ArrayList<ItemStack> zundaItems = Lists.newArrayList();

    public static void Init()
    {
        initItem();
        initTube();
        registerBackpackItems();
        initBackpack();
        BeeManager.initBees();
    }

    private static void initItem()
    {
        zundaGrafter = ItemRegister.of("zundaGrafter", new ItemTFGrafter(24)).register();
        tofuHive = BlockRegister.of("tofuHive", new BlockTFHive()).register();

        for (TFHiveType t : TFHiveType.values())
        {
            tofuHive.setHarvestLevel("scoop", 0, t.ordinal());
        }
    }

    private static void initTube()
    {
        TFTube = ItemRegister.of("thermionicTubes", new ItemTube(new ItemTubeOverlayInfo[]{
                new ItemTubeOverlayInfo("zunda", 0xffffff, 0x94c635),
                new ItemTubeOverlayInfo("tofuGem", 0xffffff, 0xfafad2),
                new ItemTubeOverlayInfo("ishiTofu", 0xffffff, 0xd3d088),
                new ItemTubeOverlayInfo("metalTofu", 0xffffff, 0xdcecff)
        })).register();
    }

    private static void initBackpack()
    {
        BackpackDefinition def = new BackpackDefinition("TofuCraftsman", tofuItems, "backpack.tofu", 16448210);
        BackpackDefinition Zdef = new BackpackDefinition("ZundaCraftsman", zundaItems, "backpack.zunda", 9750069);

        tofuBackpackT1 = ItemRegister.of("tofuBackpack1",
                BackpackManager.backpackInterface.addBackpack(def, EnumBackpackType.T1)).register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);
        tofuBackpackT2 = ItemRegister.of("tofuBackpack2",
                BackpackManager.backpackInterface.addBackpack(def, EnumBackpackType.T2)).register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);
        zundaBackpackT1 = ItemRegister.of("zundaBackpack1",
                BackpackManager.backpackInterface.addBackpack(Zdef, EnumBackpackType.T1)).register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);
        zundaBackpackT2 = ItemRegister.of("zundaBackpack2",
                BackpackManager.backpackInterface.addBackpack(Zdef, EnumBackpackType.T2)).register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);

        if (TFConfig.TofuCraftsmanExtraItems.length() > 0)
        {
            FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "TofuCraftsman@" + TFConfig.TofuCraftsmanExtraItems);
        }

        if (TFConfig.ZundaCraftsmanExtraItems.length() > 0)
        {
            FMLInterModComms.sendMessage("Forestry", "add-backpack-items", "ZundaCraftsman@" + TFConfig.ZundaCraftsmanExtraItems);
        }

        TFFarmingRegister.registerFarming();
    }

    private static void registerBackpackItems()
    {
        tofuItems.add(new ItemStack(TcItems.tofuKinu));
        tofuItems.add(new ItemStack(TcBlocks.tofuKinu));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsKinu));
        tofuItems.add(new ItemStack(TcItems.tofuMomen));
        tofuItems.add(new ItemStack(TcBlocks.tofuMomen));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsMomen));
        tofuItems.add(new ItemStack(TcItems.tofuIshi));
        tofuItems.add(new ItemStack(TcBlocks.tofuIshi));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsIshi));
        tofuItems.add(new ItemStack(TcItems.tofuMetal));
        tofuItems.add(new ItemStack(TcBlocks.tofuMetal));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsMetal));
        tofuItems.add(new ItemStack(TcItems.tofuGrilled));
        tofuItems.add(new ItemStack(TcBlocks.tofuGrilled));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsGrilled));
        tofuItems.add(new ItemStack(TcItems.tofuDried));
        tofuItems.add(new ItemStack(TcBlocks.tofuDried));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsDried));
        tofuItems.add(new ItemStack(TcItems.tofuFriedPouch));
        tofuItems.add(new ItemStack(TcBlocks.tofuFriedPouch));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsFriedPouch));
        tofuItems.add(new ItemStack(TcItems.tofuFried));
        tofuItems.add(new ItemStack(TcBlocks.tofuFried));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsFried));
        tofuItems.add(new ItemStack(TcItems.tofuEgg));
        tofuItems.add(new ItemStack(TcBlocks.tofuEgg));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsEgg));
        tofuItems.add(new ItemStack(TcItems.tofuAnnin));
        tofuItems.add(new ItemStack(TcBlocks.tofuAnnin));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsAnnin));
        tofuItems.add(new ItemStack(TcItems.tofuSesame));
        tofuItems.add(new ItemStack(TcBlocks.tofuSesame));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsSesame));
        tofuItems.add(new ItemStack(TcItems.tofuZunda));
        tofuItems.add(new ItemStack(TcBlocks.tofuZunda));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsZunda));
        tofuItems.add(new ItemStack(TcItems.tofuStrawberry));
        tofuItems.add(new ItemStack(TcBlocks.tofuStrawberry));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsStrawberry));
        tofuItems.add(new ItemStack(TcItems.tofuHell));
        tofuItems.add(new ItemStack(TcBlocks.tofuHell));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsHell));
        tofuItems.add(new ItemStack(TcItems.tofuGlow));
        tofuItems.add(new ItemStack(TcBlocks.tofuGlow));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsGlow));
        tofuItems.add(new ItemStack(TcItems.tofuDiamond));
        tofuItems.add(new ItemStack(TcBlocks.tofuDiamond));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsDiamond));
        tofuItems.add(new ItemStack(TcItems.tofuMiso));
        tofuItems.add(new ItemStack(TcBlocks.tofuMiso));
        tofuItems.add(new ItemStack(TcBlocks.tofuStairsMiso));

        tofuItems.add(new ItemStack(TcBlocks.tofuSingleSlab1, 1, OreDictionary.WILDCARD_VALUE));
        tofuItems.add(new ItemStack(TcBlocks.tofuSingleSlab2, 1, OreDictionary.WILDCARD_VALUE));
        tofuItems.add(new ItemStack(TcBlocks.tofuSingleSlab3, 1, OreDictionary.WILDCARD_VALUE));
        tofuItems.add(new ItemStack(TcBlocks.tofuSingleSlabFaces, 1, OreDictionary.WILDCARD_VALUE));
        tofuItems.add(new ItemStack(TcBlocks.tofuSingleSlabGlow, 1, OreDictionary.WILDCARD_VALUE));

        tofuItems.add(new ItemStack(TcItems.leek));
        tofuItems.add(new ItemStack(TcItems.nigari));
        tofuItems.add(new ItemStack(TcItems.okara));
        tofuItems.add(new ItemStack(TcItems.soybeans));
        tofuItems.add(new ItemStack(TcItems.soybeansHell));
        tofuItems.add(new ItemStack(TcItems.soybeansParched));
        tofuItems.add(TcItems.materials.getItemStack(ItemTcMaterials.tofuDiamondNugget));
        tofuItems.add(TcItems.materials.getItemStack(ItemTcMaterials.activatedHellTofu));
        tofuItems.add(TcItems.materials.getItemStack(ItemTcMaterials.activatedTofuGem));
        tofuItems.add(TcItems.materials.getItemStack(ItemTcMaterials.advTofuGem));
        tofuItems.add(TcItems.materials.getItemStack(ItemTcMaterials.tofuGem));
        tofuItems.add(TcItems.foodSet.getItemStack(ItemFoodSet.tofufishRow));
        tofuItems.add(new ItemStack(TcBlocks.tcSapling, 1, 1));
        tofuItems.add(new ItemStack(TcBlocks.advTofuGem));
        tofuItems.add(new ItemStack(TcBlocks.oreTofu));
        tofuItems.add(new ItemStack(TcBlocks.oreTofuDiamond));
        tofuItems.add(new ItemStack(TcBlocks.tcLeaves, 1, 2));
        tofuItems.add(new ItemStack(TcBlocks.tofuDiamond));

        zundaItems.add(new ItemStack(TcItems.zunda));
        zundaItems.add(new ItemStack(TcItems.zundama));
        zundaItems.add(new ItemStack(TcItems.zundaManju));
        zundaItems.add(new ItemStack(TcItems.zundaArrow));
        zundaItems.add(new ItemStack(TcItems.zundaBow));
        zundaItems.add(new ItemStack(TcItems.tofuZunda));
        zundaItems.add(new ItemStack(PluginTofuFactory.zundaSword));
        zundaItems.add(new ItemStack(PluginTofuFactory.zundaIngot));
        zundaItems.add(TcItems.foodSet.getItemStack(ItemFoodSet.zundaMochi));
        if (TFPluginManager.modIC2)
        {
            zundaItems.add(new ItemStack(PluginIC2.zundaBattery));
            zundaItems.add(new ItemStack(PluginIC2.zundaSwordBow));
        }
    }
}
