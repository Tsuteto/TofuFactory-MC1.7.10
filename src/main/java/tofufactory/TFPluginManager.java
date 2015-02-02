package tofufactory;

import cpw.mods.fml.common.Loader;
import tofufactory.config.TFConfig;
import tofufactory.plugin.PluginAppeng;
import tofufactory.plugin.PluginBC;
import tofufactory.plugin.PluginBamboo;
import tofufactory.plugin.PluginFC;
import tofufactory.plugin.PluginFFM;
import tofufactory.plugin.PluginGreg;
import tofufactory.plugin.PluginIC2;
import tofufactory.plugin.PluginMT;
import tofufactory.plugin.PluginTC;
import tofufactory.plugin.PluginTcon;

public class TFPluginManager
{
    public static boolean modBuildCraft;
    public static boolean modForestry;
    public static boolean modIC2;
    public static boolean modFC;
    public static boolean modGT;
    public static boolean modMT;
    public static boolean modBamboo;
    public static boolean modAppeng;
    public static boolean modTC;
    public static boolean modTConstruct;

    public static void initPlugins()
    {
        modBuildCraft = Loader.isModLoaded("BuildCraft|Core");
        modForestry = Loader.isModLoaded("Forestry");
        modIC2 = Loader.isModLoaded("IC2");
        modFC = Loader.isModLoaded("FarmCraftory"); // 1.6.2 yet
        modGT = Loader.isModLoaded("gregtech_addon");
        modMT = Loader.isModLoaded("mod_ecru_MapleTree");
        modBamboo = Loader.isModLoaded("BambooMod"); // Not tested
        modAppeng = Loader.isModLoaded("appliedenergistics2");
        modTC = Loader.isModLoaded("Thaumcraft");
        modTConstruct = Loader.isModLoaded("TConstruct");

        if (modBuildCraft && TFConfig.BuildCraft)
        {
            try
            {
                PluginBC.registeBuildCraft();
            }
            catch (Exception var10)
            {
                System.out.println("Tofu Factory: Build Craft integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modForestry && TFConfig.Forestry)
        {
            try
            {
                PluginFFM.Init();
            }
            catch (Exception var9)
            {
                System.out.println("Tofu Factory: Forestry integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modIC2 && TFConfig.IC2)
        {
            try
            {
                PluginIC2.Init();
            }
            catch (Exception var8)
            {
                System.out.println("Tofu Factory: IC2 integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modFC)
        {
            try
            {
                PluginFC.Init();
            }
            catch (Exception var7)
            {
                System.out.println("Tofu Factory: FarmCraftory integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modGT && TFConfig.Greg)
        {
            try
            {
                PluginGreg.Init();
            }
            catch (Exception var6)
            {
                System.out.println("Tofu Factory: gregtech_addon integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modMT && TFConfig.MapleTree)
        {
            try
            {
                PluginMT.Init();
            }
            catch (Exception var5)
            {
                System.out.println("Tofu Factory: MapleTree integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modBamboo && TFConfig.Bamboo)
        {
            try
            {
                PluginBamboo.Init();
            }
            catch (Exception var4)
            {
                System.out.println("Tofu Factory: Bamboo integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modAppeng && TFConfig.AppliedEnergistics)
        {
            try
            {
                PluginAppeng.Init();
            }
            catch (Exception var3)
            {
                System.out.println("Tofu Factory: AppliedEnergistics integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modTC && TFConfig.ThaumCraft)
        {
            try
            {
                PluginTC.Init();
            }
            catch (Exception var2)
            {
                System.out.println("Tofu Factory: ThaumCraft integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }

        if (modTConstruct && TFConfig.Tcon)
        {
            try
            {
                PluginTcon.Init();
            }
            catch (Exception var1)
            {
                System.out.println("Tofu Factory: TConstruct integration was unsuccessful - please contact the author of this mod to let them know that the API may have changed.");
            }
        }
    }
}
