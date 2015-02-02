package tofufactory.block;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tofufactory.TofuFactory;
import tofufactory.plugin.PluginTofuFactory;
import tofufactory.tileEntity.TileEntityTofuCompactor;

public class BlockTofuCompactor extends BlockTofuMachine
{
    public BlockTofuCompactor(boolean par2)
    {
        super(par2, false);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityTofuCompactor();
    }

    public Block getIdleBlock()
    {
        return PluginTofuFactory.tofuCompactorIdle;
    }

    public Block getRunningBlock()
    {
        return PluginTofuFactory.tofuCompactorActive;
    }

    public void displayGUIBook(EntityPlayer par5EntityPlayer, World par1World, int par2, int par3, int par4)
    {
        par5EntityPlayer.openGui(TofuFactory.instance, 1, par1World, par2, par3, par4);
    }
}
