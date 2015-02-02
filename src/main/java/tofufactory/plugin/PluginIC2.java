package tofufactory.plugin;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import tofufactory.TFPluginManager;
import tofufactory.TofuFactory;
import tofufactory.fluid.TFFluids;
import tofufactory.item.ItemTFCell;
import tofufactory.item.ItemZundaBattery;
import tofufactory.item.ItemZundaSwordBow;
import tofufactory.registry.ItemRegister;
import tsuteto.tofu.fluids.TcFluids;
import tsuteto.tofu.item.TcItems;

public class PluginIC2
{
    public static Item zundaBattery;
    public static Item zundaSwordBow;
    public static Item zundaSwordBowEmpty;
    public static String[] CellName;
    public static Item TFCell;

    public static void Init()
    {
        initItem();
        initCell();
    }

    private static void initItem()
    {
        zundaBattery = ItemRegister.of("zundaBattery", new ItemZundaBattery())
                .register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);
        zundaSwordBow = ItemRegister.of("zunda_swordBow", new ItemZundaSwordBow(PluginTofuFactory.ZUNDA))
                .register();
        zundaSwordBowEmpty = ItemRegister.of("zunda_swordBowE", new Item())
                .withResource("zunda_swordBow")
                .register();

        GameRegistry.addShapelessRecipe(new ItemStack(zundaBattery, 1), new ItemStack(PluginTofuFactory.zundaIngot, 1), new ItemStack(Items.redstone, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(zundaSwordBow, 1), new ItemStack(zundaBattery, 1), new ItemStack(TcItems.zundaBow, 1), new ItemStack(PluginTofuFactory.zundaSword, 1));

        if (TFPluginManager.modForestry)
        {
            registerFFM();
        }
    }

    private static void initCell()
    {
        CellName = new String[] {"bittern", "drinkingWater", "noodleSoup", "soupStock", "zundaWater", "soymilk", "soymilkHell", "soySauce"};
        TFCell = ItemRegister.of("TFCell", new ItemTFCell(CellName)).register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);

        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TFFluids.bittern.getName(), 1000), new ItemStack(TFCell, 1, 0), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TFFluids.drinkingWater.getName(), 1000), new ItemStack(TFCell, 1, 1), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TFFluids.noodleSoup.getName(), 1000), new ItemStack(TFCell, 1, 2), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TFFluids.soupStock.getName(), 1000), new ItemStack(TFCell, 1, 3), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TFFluids.zunda.getName(), 1000), new ItemStack(TFCell, 1, 4), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TcFluids.SOYMILK.getName(), 1000), new ItemStack(TFCell, 1, 5), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TcFluids.SOYMILK_HELL.getName(), 1000), new ItemStack(TFCell, 1, 6), IC2Items.getItem("cell")));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack(TcFluids.SOY_SAUCE.getName(), 1000), new ItemStack(TFCell, 1, 7), IC2Items.getItem("cell")));
    }

    private static void registerFFM() {}
}
