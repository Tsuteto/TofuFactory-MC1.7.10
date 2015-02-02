package tofufactory.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ItemTFMaterial extends ItemSetBase
{
    public ItemTFMaterial(String[] name)
    {
        super(name);
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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.icons = new IIcon[this.names.length];

        for (int i = 0; i < this.names.length; ++i)
        {
            String name = this.names[i];
            this.icons[i] = register.registerIcon("tofufactory:material/" + name);
        }

        this.itemIcon = register.registerIcon("tofufactory:zundaIngot");
    }
}
