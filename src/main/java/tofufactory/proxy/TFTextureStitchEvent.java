package tofufactory.proxy;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent.Pre;
import tofufactory.plugin.PluginBC;

public class TFTextureStitchEvent
{
    private static TFTextureStitchEvent instance;
    String[] iconNames = new String[] {"tofufactory:smokeTofu", "tofufactory:smokeTofuGlow"};
    IIcon[] icons;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureHook(Pre event)
    {
        int type = event.map.getTextureType();
        if (type == 0)
        {
            PluginBC.pipeIconProvider.registerIcons(event.map);
        }

        if (type == 1)
        {
            getInstance().registerIcons(event.map);
        }
    }

    public static TFTextureStitchEvent getInstance()
    {
        if (instance == null)
        {
            instance = new TFTextureStitchEvent();
        }

        return instance;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.icons = new IIcon[this.iconNames.length];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = par1IconRegister.registerIcon(this.iconNames[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(String iconName)
    {
        for (int i = 0; i < this.iconNames.length; ++i)
        {
            if (iconName.equalsIgnoreCase(this.iconNames[i]))
            {
                return this.icons[i];
            }
        }

        return null;
    }
}
