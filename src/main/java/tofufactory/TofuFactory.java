package tofufactory;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tofufactory.achievement.TFTriggerManager;
import tofufactory.config.TFConfig;
import tofufactory.fluid.TFFluids;
import tofufactory.gui.TFGuiHandler;
import tofufactory.plugin.PluginTofuFactory;
import tofufactory.proxy.CommonProxy;
import tofufactory.proxy.TFTextureStitchEvent;
import tofufactory.machinerecipe.TofuMachineRecipe;
import tofufactory.registry.BlockRegister;
import tofufactory.registry.ItemRegister;

@Mod(
    modid = TofuFactory.modId,
    name = "Tofu Factory",
    version = TofuFactory.version,
    dependencies = "after:TofuCraft;after:BuildCraft"
)
public class TofuFactory
{
    public static final String modId = "TofuFactory";
    public static final String version = "1.5.0-MC1.7.10";
    public static final String resourceDomain = "tofufactory:";
    public static final Logger tfLog = LogManager.getLogger("TofuFactory");

    @Instance("TofuFactory")
    public static TofuFactory instance;

    @SidedProxy(
        clientSide = "tofufactory.proxy.ClientProxy",
        serverSide = "tofufactory.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    public static final CreativeTabs tabsTofuFactory = new CreativeTabTofuFactory("TofuFactory");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        tfLog.info("Starting TofuFactory " + version);
        TFConfig.ConfigRead(event);

        ItemRegister.setResourceDomain(resourceDomain);
        BlockRegister.setResourceDomain(resourceDomain);

        TFFluids.registerFluids();

        if (event.getSide() == Side.CLIENT)
        {
            MinecraftForge.EVENT_BUS.register(new TFFluids());
        }

        MinecraftForge.EVENT_BUS.register(new TFTextureStitchEvent());
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new TFGuiHandler());

        TofuMachineRecipe.initRecipe();
        PluginTofuFactory.Init();
        TFAchievementManager.initAchievement();
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new TFTriggerManager());
        TFOreDictionary.registeOreDictionary();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        TFPluginManager.initPlugins();
        TFRecipeManager.registerRecipes();
    }
}
