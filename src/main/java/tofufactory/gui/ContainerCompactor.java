package tofufactory.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import tofufactory.api.recipes.IMachineRecipe;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.tileEntity.TileEntityTofuMachine;

public class ContainerCompactor extends ContainerTofuMachine
{
    public ContainerCompactor(InventoryPlayer par1InventoryPlayer, TileEntityTofuMachine par2TileEntityFurnace)
    {
        super(par1InventoryPlayer, par2TileEntityFurnace);
    }

    public IMachineRecipe getMachineRecipe()
    {
        return RecipeManagers.compactorManager;
    }

    public SlotTofuMachine getMachineSlot(EntityPlayer player, TileEntityTofuMachine par2TileEntityFurnace, int i, int j, int k)
    {
        return new SlotPulverizer(player, par2TileEntityFurnace, i, j, k);
    }
}
