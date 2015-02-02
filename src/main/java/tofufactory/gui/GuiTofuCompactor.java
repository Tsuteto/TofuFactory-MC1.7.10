package tofufactory.gui;

import net.minecraft.entity.player.InventoryPlayer;
import tofufactory.tileEntity.TileEntityTofuMachine;

public class GuiTofuCompactor extends GuiTofuMachine
{
    public GuiTofuCompactor(InventoryPlayer par1InventoryPlayer, TileEntityTofuMachine par2TileEntityTofuMachine)
    {
        super(new ContainerCompactor(par1InventoryPlayer, par2TileEntityTofuMachine), par2TileEntityTofuMachine);
    }

    protected String getGuiImgName()
    {
        return "TofuCompactor";
    }
}
