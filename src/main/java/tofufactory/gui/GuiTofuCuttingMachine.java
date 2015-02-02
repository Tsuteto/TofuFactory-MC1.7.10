package tofufactory.gui;

import net.minecraft.entity.player.InventoryPlayer;
import tofufactory.tileEntity.TileEntityTofuMachine;

public class GuiTofuCuttingMachine extends GuiTofuMachine
{
    public GuiTofuCuttingMachine(InventoryPlayer par1InventoryPlayer, TileEntityTofuMachine par2TileEntityTofuMachine)
    {
        super(new ContainerCuttingMachine(par1InventoryPlayer, par2TileEntityTofuMachine), par2TileEntityTofuMachine);
    }

    protected String getGuiImgName()
    {
        return "TofuCuttingMachine";
    }
}
