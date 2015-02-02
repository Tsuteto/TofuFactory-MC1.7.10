package tofufactory;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.FMLCommonHandler;

import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import tofufactory.achievement.TFAchievement;
import tofufactory.achievement.TFTriggerManager;
import tofufactory.plugin.PluginTofuFactory;

public class TFAchievementManager
{
    public static final String ACHIEVEMENT_PAGE_NAME = "Tofu Factory";
    public static Map<String, TFAchievement> achievementList = Maps.newHashMap();

    public static void initAchievement()
    {
        FMLCommonHandler.instance().bus().register(new TFTriggerManager());

        (new TFAchievement("tofufactory:mithril", "Mithril", 3, 2, new ItemStack(PluginTofuFactory.oreMithril, 1), (Achievement)null))
                .registerStat()
                .setTriggerItemPickup(new ItemStack(PluginTofuFactory.oreMithril, 1))
                .setTitle("The beginning of the magic", "\u9b54\u6cd5\u306e\u59cb\u307e\u308a")
                .setDesc("Let\'s get the Mithril", "\u30df\u30b9\u30ea\u30eb\u3092\u624b\u306b\u5165\u308c\u307e\u3057\u3087\u3046");
        (new TFAchievement("tofufactory:magicPowder", "MagicPowder", 5, 1, new ItemStack(PluginTofuFactory.tofuDust, 1, 1), (Achievement)achievementList.get("Mithril")))
                .registerStat()
                .setTriggerItemPickup(new ItemStack(PluginTofuFactory.tofuDust, 1, 1))
                .setTitle("Magic powder", "\u9b54\u6cd5\u306e\u7c89")
                .setDesc("Let\'s crush the Mithril", "\u30df\u30b9\u30ea\u30eb\u3092\u7c89\u7815\u3057\u307e\u3057\u3087\u3046");

        Achievement[] array = achievementList.values().toArray(new Achievement[achievementList.size()]);
        AchievementPage.registerAchievementPage(new AchievementPage(ACHIEVEMENT_PAGE_NAME, array));
    }
}
