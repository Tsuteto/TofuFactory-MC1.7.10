package tofufactory.plugin;

import buildcraft.BuildCraftTransport;
import buildcraft.api.core.IIconProvider;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.recipes.RefineryRecipeManager;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.PipeTransportFluids;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.pipes.PipeFluidsCobblestone;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tofufactory.TFPipeIconProvider;
import tofufactory.TofuFactory;
import tofufactory.fluid.TFFluids;
import tofufactory.pipe.PipeFluidsTofuIshi;
import tofufactory.pipe.PipeFluidsZunda;
import tofufactory.pipe.PipeItemsTofuIshi;
import tofufactory.pipe.PipeItemsZunda;
import tofufactory.pipe.PipePowerTofuIshi;
import tofufactory.pipe.PipePowerZunda;
import tsuteto.tofu.fluids.TcFluids;
import tsuteto.tofu.item.TcItems;

public class PluginBC
{
    public static Item pipeItemsTofuIshi;
    public static Item pipeFluidsTofuIshi;
    public static Item pipePowerTofuIshi;
    public static Item pipeItemsZunda;
    public static Item pipeFluidsZunda;
    public static Item pipePowerZunda;
    public static IIconProvider pipeIconProvider = new TFPipeIconProvider();

    public static void registeBuildCraft()
    {
        // Pipe Items
        pipeItemsTofuIshi = BlockGenericPipe.registerPipe(PipeItemsTofuIshi.class, CreativeTabBuildCraft.PIPES);
        pipeItemsTofuIshi.setUnlocalizedName(TofuFactory.resourceDomain + "pipe.item.tofuIshi").setCreativeTab(TofuFactory.tabsTofuFactory);

        PipeTransportFluids.fluidCapacities.put(PipeFluidsTofuIshi.class, 2 * BuildCraftTransport.pipeFluidsBaseFlowRate);
        pipeFluidsTofuIshi = BlockGenericPipe.registerPipe(PipeFluidsTofuIshi.class, CreativeTabBuildCraft.PIPES);
        pipeFluidsTofuIshi.setUnlocalizedName(TofuFactory.resourceDomain + "pipe.fluid.tofuIshi").setCreativeTab(TofuFactory.tabsTofuFactory);

        PipeTransportPower.powerCapacities.put(PipePowerTofuIshi.class, 128);
        pipePowerTofuIshi = BlockGenericPipe.registerPipe(PipePowerTofuIshi.class, CreativeTabBuildCraft.PIPES);
        pipePowerTofuIshi.setUnlocalizedName(TofuFactory.resourceDomain + "pipe.power.tofuIshi").setCreativeTab(TofuFactory.tabsTofuFactory);

        pipeItemsZunda = BlockGenericPipe.registerPipe(PipeItemsZunda.class, CreativeTabBuildCraft.PIPES);
        pipeItemsZunda.setUnlocalizedName(TofuFactory.resourceDomain + "pipe.item.zunda").setCreativeTab(TofuFactory.tabsTofuFactory);

        PipeTransportFluids.fluidCapacities.put(PipeFluidsZunda.class, 2 * BuildCraftTransport.pipeFluidsBaseFlowRate);
        pipeFluidsZunda = BlockGenericPipe.registerPipe(PipeFluidsZunda.class, CreativeTabBuildCraft.PIPES);
        pipeFluidsZunda.setUnlocalizedName(TofuFactory.resourceDomain + "pipe.fluid.zunda").setCreativeTab(TofuFactory.tabsTofuFactory);

        PipeTransportPower.powerCapacities.put(PipePowerZunda.class, 128);
        pipePowerZunda = BlockGenericPipe.registerPipe(PipePowerZunda.class, CreativeTabBuildCraft.PIPES);
        pipePowerZunda.setUnlocalizedName(TofuFactory.resourceDomain + "pipe.power.zunda").setCreativeTab(TofuFactory.tabsTofuFactory);

//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuTerrain, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuKinu, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuMomen, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuIshi, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuMetal, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuGrilled, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuDried, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuFriedPouch, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuFried, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuEgg, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuAnnin, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuSesame, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuZunda, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuStrawberry, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuHell, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuGlow, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuDiamond, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tofuSesame, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.barrelMiso, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.natto, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.barrelMiso, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.salt, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.oreTofu, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.oreTofuDiamond, 0));
//        FacadeManager.addFacade(new ItemStack(TcBlocks.tcLog, 0));
        TofuFactory.proxy.registerRenderersBC();
    }
}
