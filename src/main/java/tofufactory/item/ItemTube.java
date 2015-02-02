package tofufactory.item;

import com.google.common.collect.Lists;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import tofufactory.TofuFactory;

import java.util.List;

public class ItemTube extends ItemSetBase
{
    private ItemTubeOverlayInfo[] overlays;
    private String[] tubeNames;
    @SideOnly(Side.CLIENT)
    private IIcon primaryIcon;
    @SideOnly(Side.CLIENT)
    private IIcon secondaryIcon;

    public ItemTube(ItemTubeOverlayInfo[] overlays)
    {
        super();
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        this.overlays = overlays;

        List<String> names = Lists.newArrayList();
        for (ItemTubeOverlayInfo overlay : overlays)
        {
            names.add(overlay.name);
        }
        this.tubeNames = names.toArray(new String[names.size()]);
    }

    @Override
    public boolean isDamageable()
    {
        return false;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List itemList)
    {
        for (int i = 0; i < this.overlays.length; ++i)
        {
            if (!this.overlays[i].isSecret)
            {
                itemList.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.primaryIcon = register.registerIcon("forestry:" + this.getUnlocalizedName().replace("item." + TofuFactory.resourceDomain, "") + ".0");
        this.secondaryIcon = register.registerIcon("forestry:" + this.getUnlocalizedName().replace("item." + TofuFactory.resourceDomain, "") + ".1");
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    public IIcon getIconFromDamageForRenderPass(int i, int j)
    {
        return j > 0 ? this.secondaryIcon : this.primaryIcon;
    }

    @Override
    public int getRenderPasses(int metadata)
    {
        return 2;
    }

    @Override
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemstack, int j)
    {
        return j != 0 && this.overlays[itemstack.getItemDamage()].secondaryColor != 0 ? this.overlays[itemstack.getItemDamage()].secondaryColor : this.overlays[itemstack.getItemDamage()].primaryColor;
    }

    @Override
    public String[] getItemList()
    {
        return this.tubeNames;
    }

    @Override
    public String getItemSetName()
    {
        return "tube";
    }

}
