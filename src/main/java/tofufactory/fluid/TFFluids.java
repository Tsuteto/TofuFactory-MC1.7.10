package tofufactory.fluid;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import tsuteto.tofu.fluids.TcFluids;
import tsuteto.tofu.item.TcItems;

public class TFFluids
{
    public static Fluid soupStock;
    public static Fluid noodleSoup;
    public static Fluid zunda;
    public static Fluid drinkingWater;
    public static Fluid bittern;
    public static Fluid moltenZundaFluid;

    public static void registerFluids()
    {
        soupStock = new Fluid("SoupStock");
        FluidRegistry.registerFluid(soupStock);
        FluidContainerRegistry.registerFluidContainer(
                new FluidContainerData(FluidRegistry.getFluidStack(soupStock.getName(), 500),
                        new ItemStack(TcItems.dashi), new ItemStack(Items.glass_bottle)));

        noodleSoup = new Fluid("NoodleSoup");
        FluidRegistry.registerFluid(noodleSoup);

        zunda = new Fluid("Zunda");
        FluidRegistry.registerFluid(zunda);

        drinkingWater = new Fluid("DrinkingWater");
        FluidRegistry.registerFluid(drinkingWater);

        bittern = TcFluids.NIGARI;
//        bittern = new Fluid("Bittern");
//        FluidRegistry.registerFluid(bittern);
//        FluidContainerRegistry.registerFluidContainer(
//                new FluidContainerData(FluidRegistry.getFluidStack(bittern.getName(), 500),
//                        new ItemStack(TcItems.nigari), new ItemStack(Items.glass_bottle)));

        moltenZundaFluid = new Fluid("MoltenZunda");
        FluidRegistry.registerFluid(moltenZundaFluid);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureHook(Pre event)
    {
        if (soupStock != null && event.map.getTextureType() == 0)
        {
            String n = "fluid/";
            IIcon SoupStockIcon = event.map.registerIcon("tofufactory:" + n + "liquidSoupStock");
            soupStock.setIcons(SoupStockIcon);
            IIcon NoodleSoupIcon = event.map.registerIcon("tofufactory:" + n + "NoodleSoup");
            noodleSoup.setIcons(NoodleSoupIcon);
            IIcon ZundaIcon = event.map.registerIcon("tofufactory:" + n + "zunda_water");
            zunda.setIcons(ZundaIcon);
            IIcon DrinkingWaterIcon = event.map.registerIcon("tofufactory:" + n + "Drinking_water");
            drinkingWater.setIcons(DrinkingWaterIcon);
            IIcon BitternIcon = event.map.registerIcon("tofufactory:" + n + "Bittern");
            bittern.setIcons(BitternIcon);
            IIcon moltenZundaFluidIcon = event.map.registerIcon("tofufactory:" + n + "moltenZundaFluid");
            moltenZundaFluid.setIcons(moltenZundaFluidIcon);
        }
    }
}
