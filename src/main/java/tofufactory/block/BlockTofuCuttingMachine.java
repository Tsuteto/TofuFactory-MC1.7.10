package tofufactory.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tofufactory.TofuFactory;
import tofufactory.plugin.PluginTofuFactory;
import tofufactory.tileEntity.TileEntityTofuCuttingMachine;

public class BlockTofuCuttingMachine extends BlockTofuMachine
{
    public BlockTofuCuttingMachine(boolean par2, boolean icon)
    {
        super(par2, icon);
    }

    public BlockTofuCuttingMachine(boolean b)
    {
        this(b, false);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityTofuCuttingMachine();
    }

    public Block getIdleBlock()
    {
        return PluginTofuFactory.tofuCuttingMachineIdle;
    }

    public Block getRunningBlock()
    {
        return PluginTofuFactory.tofuCuttingMachineActive;
    }

    public void displayGUIBook(EntityPlayer par5EntityPlayer, World par1World, int par2, int par3, int par4)
    {
        par5EntityPlayer.openGui(TofuFactory.instance, 2, par1World, par2, par3, par4);
    }
}
