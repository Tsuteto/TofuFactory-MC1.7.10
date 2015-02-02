package tofufactory.plugin;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import tofufactory.TofuFactory;
import tofufactory.item.ItemTFFocus;
import tofufactory.registry.ItemRegister;
import tsuteto.tofu.block.TcBlocks;

public class PluginTC
{
    public static Aspect TOFU;
    public static String ResearchTOFU = "Tofu";
    public static Item tofuFocus;

    public static void Init()
    {
        initAspect();
        registerAspect();

        ResearchCategories.registerCategory(ResearchTOFU, new ResourceLocation("tofufactory", "textures/items/smokeTofu.png"), new ResourceLocation("tofufactory", "textures/gui/guiTofuKinu.png"));

        tofuFocus = ItemRegister.of("tofuFocus", new ItemTFFocus()).register()
                .setCreativeTab(TofuFactory.tabsTofuFactory);
    }

    private static void initAspect()
    {
        TOFU = new Aspect("tofu", 16777200,
                new Aspect[] {Aspect.WATER, Aspect.CROP},
                new ResourceLocation("thaumcraft", "textures/aspects/terra.png"), 1);
    }

    private static void registerAspect()
    {
        $(TcBlocks.tofuTerrain)
                .add(TOFU, 3).add(Aspect.WATER, 3)
                .register();
        $(TcBlocks.tofuKinu)
                .add(TOFU, 6).add(Aspect.WATER, 6)
                .register();
        $(TcBlocks.tofuMomen)
                .add(TOFU, 4).add(Aspect.WATER, 4)
                .register();
        $(TcBlocks.tofuIshi)
                .add(TOFU, 4).add(Aspect.WATER, 2).add(Aspect.EARTH, 4)
                .register();
        $(TcBlocks.tofuMetal)
                .add(TOFU, 6).add(Aspect.METAL, 6).add(Aspect.EARTH, 2)
                .register();
        $(TcBlocks.tofuGrilled)
                .add(TOFU, 4).add(Aspect.WATER, 2).add(Aspect.FIRE, 6)
                .register();
        $(TcBlocks.tofuDried)
                .add(TOFU, 4).add(Aspect.WATER, 2).add(Aspect.FIRE, 2)
                .register();
        $(TcBlocks.tofuFriedPouch)
                .add(TOFU, 4).add(Aspect.WATER, 4).add(Aspect.FIRE, 4)
                .register();
        $(TcBlocks.tofuFried)
                .add(TOFU, 4).add(Aspect.WATER, 2).add(Aspect.FIRE, 2)
                .register();
        $(TcBlocks.tofuEgg)
                .add(TOFU, 2).add(Aspect.WATER, 4).add(Aspect.LIFE, 2)
                .register();
        $(TcBlocks.tofuAnnin)
                .add(TOFU, 3).add(Aspect.WATER, 10).add(Aspect.GREED, 5)
                .register();
        $(TcBlocks.tofuSesame)
                .add(TOFU, 2).add(Aspect.WATER, 10).add(Aspect.MIND, 5)
                .register();
        $(TcBlocks.tofuZunda)
                .add(TOFU, 3).add(Aspect.WATER, 15).add(Aspect.HEAL, 5)
                .register();
        $(TcBlocks.tofuStrawberry)
                .add(TOFU, 3).add(Aspect.WATER, 8).add(Aspect.GREED, 5)
                .register();
        $(TcBlocks.tofuHell)
                .add(TOFU, 6).add(Aspect.DEATH, 2).add(Aspect.MAN, 2)
                .register();
        $(TcBlocks.tofuDiamond)
                .add(TOFU, 20).add(Aspect.CRYSTAL, 20)
                .register();

        $(TcBlocks.tofuMiso)
                .add(TOFU, 6).add(Aspect.GREED, 10)
                .register();
        $(TcBlocks.advTofuGem)
                .add(TOFU, 10).add(Aspect.CRYSTAL, 3).add(Aspect.AURA, 6)
                .register();
        $(TcBlocks.yuba)
                .add(TOFU, 2).add(Aspect.WATER, 3)
                .register();
        $(TcBlocks.chikuwaPlatformPlain)
                .add(Aspect.GREED, 4).add(Aspect.FLIGHT, 6)
                .register();
        $(TcBlocks.chikuwaPlatformTofu)
                .add(TOFU, 3).add(Aspect.GREED, 4).add(Aspect.FLIGHT, 6)
                .register();
        $(TcBlocks.tcLeaves).withMetadata(2, 10)
                .add(TOFU, 8).add(Aspect.PLANT, 4)
                .register();
        $(TcBlocks.soybean)
                .add(TOFU, 1).add(Aspect.CROP, 4)
                .register();
        $(TcBlocks.leek)
                .add(Aspect.PLANT, 3).add(Aspect.CROP, 3)
                .register();
        $(TcBlocks.morijio)
                .add(Aspect.AURA, 2).add(Aspect.ORDER, 4).add(Aspect.AIR, 4)
                .register();
        $(TcBlocks.nattoBed)
                .add(Aspect.AIR, 5).add(Aspect.SLIME, 2).add(Aspect.WEATHER, 1)
                .register();
        $(TcBlocks.natto)
                .add(Aspect.SLIME, 6).add(Aspect.TRAP, 3).add(Aspect.GREED, 2)
                .register();
        $(TcBlocks.salt)
                .add(Aspect.ORDER, 2).add(Aspect.EARTH, 2).add(Aspect.GREED, 1)
                .register();
        $(TcBlocks.sesame)
                .add(Aspect.CROP, 5)
                .register();
        $(TcBlocks.tfAntennaMedium)
                .add(TOFU, 5).add(Aspect.AIR, 10).add(Aspect.ENERGY, 5)
                .register();
        $(TcBlocks.tfAntennaUltra)
                .add(TOFU, 5).add(Aspect.AIR, 15).add(Aspect.ENERGY, 8)
                .register();
        $(TcBlocks.tfAntennaSuper)
                .add(TOFU, 5).add(Aspect.AIR, 20).add(Aspect.ENERGY, 10)
                .register();

        // TODO: TF machines
//        $(TcBlocks.tfCollector)
//                .add(TOFU, 5).add(Aspect.ENTROPY, 10).add(Aspect.AIR, 5)
//                .register();
    }
    
    private static AspectRegister $(Block block)
    {
        return $(new ItemStack(block));
    }

    private static AspectRegister $(ItemStack itemStack)
    {
        return new AspectRegister(itemStack);
    }

    private static class AspectRegister
    {
        ItemStack itemStack;
        int[] metadata = new int[]{-1};
        AspectList aspectList = new AspectList();

        public AspectRegister(ItemStack itemStack)
        {
            this.itemStack = itemStack;
        }

        AspectRegister withMetadata(int... metadata)
        {
            this.metadata = metadata;
            return this;
        }

        AspectRegister add(Aspect aspect, int amount)
        {
            aspectList.add(aspect, amount);
            return this;
        }

        void register()
        {
            ThaumcraftApi.registerObjectTag(itemStack, metadata, aspectList);
        }
    }
}
