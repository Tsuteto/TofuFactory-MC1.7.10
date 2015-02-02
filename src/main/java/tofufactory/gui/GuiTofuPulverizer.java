package tofufactory.gui;

import net.minecraft.entity.player.InventoryPlayer;
import tofufactory.tileEntity.TileEntityTofuMachine;

public class GuiTofuPulverizer extends GuiTofuMachine
{
    public GuiTofuPulverizer(InventoryPlayer par1InventoryPlayer, TileEntityTofuMachine par2TileEntityTofuMachine)
    {
        super(new ContainerPulverizer(par1InventoryPlayer, par2TileEntityTofuMachine), par2TileEntityTofuMachine);
    }

    protected String getGuiImgName()
    {
        return "TofuPulverizer";
    }
}
