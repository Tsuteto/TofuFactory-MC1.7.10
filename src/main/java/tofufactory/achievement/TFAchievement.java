package tofufactory.achievement;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import tofufactory.TFAchievementManager;

public class TFAchievement extends Achievement
{
    private AchievementTrigger trigger;
    private final String name;

    public TFAchievement(String par1, String par2Str, int par3, int par4, ItemStack par5ItemStack, Achievement par6Achievement)
    {
        super(par1, par2Str, par3, par4, par5ItemStack, par6Achievement);
        this.name = par2Str;
    }

    public TFAchievement registerStat()
    {
        super.registerStat();
        TFAchievementManager.achievementList.put(this.name, this);
        return this;
    }

    public TFAchievement setTitle(String en, String ja)
    {
        LanguageRegistry.instance().addStringLocalization(this.name, "en_US", en);
        LanguageRegistry.instance().addStringLocalization(this.name, "ja_JP", ja);
        return this;
    }

    public TFAchievement setDesc(String en, String ja)
    {
        LanguageRegistry.instance().addStringLocalization(this.name + ".desc", "en_US", en);
        LanguageRegistry.instance().addStringLocalization(this.name + ".desc", "ja_JP", ja);
        return this;
    }

    public TFAchievement setTriggerItemPickup(ItemStack item)
    {
        this.trigger = new AchievementTrigger(item);
        TFTriggerManager.itemPickupMap.add(this);
        return this;
    }

    public TFAchievement setTriggerItemCrafting(ItemStack item)
    {
        this.trigger = new AchievementTrigger(item);
        TFTriggerManager.itemCraftingMap.add(this);
        return this;
    }

    public AchievementTrigger getTrigger()
    {
        return this.trigger;
    }
}
