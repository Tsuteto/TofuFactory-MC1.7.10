package tofufactory.config;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import org.apache.logging.log4j.Level;

public class TFConfig
{
    public static boolean BuildCraft;
    public static boolean Forestry;
    public static boolean IC2;
    public static boolean Greg;
    public static boolean FarmCraftory;
    public static boolean MapleTree;
    public static boolean Bamboo;
    public static boolean AppliedEnergistics;
    public static boolean ThaumCraft;
    public static boolean Tcon;
    public static String TofuCraftsmanExtraItems;
    public static String ZundaCraftsmanExtraItems;

    public static void ConfigRead(FMLPreInitializationEvent event)
    {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

        try
        {
            cfg.load();
            ConfigForTofuFactory(cfg);
            ConfigForTofuBC(cfg);
            ConfigForForestry(cfg);
            ConfigForIC2(cfg);
            ConfigForTC(cfg);
        }
        catch (Exception var6)
        {
            FMLLog.log(Level.FATAL, var6, "\u30a8\u30e9\u30fc\u30e1\u30c3\u30bb\u30fc\u30b8");
        }
        finally
        {
            cfg.save();
        }
    }

    public static void ConfigForTofuFactory(Configuration cfg)
    {
        BuildCraft = cfg.get("general", "BuildCraft", true, "Cooperation with the BuildCraft").getBoolean(true);
        Forestry = cfg.get("general", "Forestry", true, "Cooperation with the forestry").getBoolean(true);
        IC2 = cfg.get("general", "IC2", true, "Cooperation with the IC2").getBoolean(true);
        Greg = cfg.get("general", "Greg", true, "Cooperation with the Greg").getBoolean(true);
        FarmCraftory = cfg.get("general", "FarmCraftory", true, "Cooperation with the FarmCraftory").getBoolean(true);
        MapleTree = cfg.get("general", "MapleTree", true, "Cooperation with the MapleTree").getBoolean(true);
        Bamboo = cfg.get("general", "Bamboo", true, "Cooperation with the Bamboo").getBoolean(true);
        AppliedEnergistics = cfg.get("general", "AppliedEnergistics", true, "Cooperation with the AppliedEnergistics").getBoolean(true);
        ThaumCraft = cfg.get("general", "ThaumCraft", true, "Cooperation with the ThaumCraft").getBoolean(true);
        Tcon = cfg.get("general", "TConstruct", true, "Cooperation with the TConstruct").getBoolean(true);
    }

    public static void ConfigForTofuBC(Configuration cfg)
    {
    }

    public static void ConfigForForestry(Configuration cfg)
    {
        Property pT = cfg.get("General_Forestry", "Backpack_Tofu_AdditionalItems", "");
        TofuCraftsmanExtraItems = pT.getString();
        Property pZ = cfg.get("General_Forestry", "Backpack_Zunda_AdditionalItems", "");
        ZundaCraftsmanExtraItems = pT.getString();
    }

    public static void ConfigForIC2(Configuration cfg)
    {
    }

    public static void ConfigForTC(Configuration cfg)
    {
    }
}
