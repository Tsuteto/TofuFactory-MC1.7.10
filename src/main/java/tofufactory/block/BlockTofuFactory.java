package tofufactory.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import tofufactory.TofuFactory;

public class BlockTofuFactory extends Block
{
    public BlockTofuFactory(Material par2Material)
    {
        super(par2Material);
        this.setCreativeTab(TofuFactory.tabsTofuFactory);
    }

    @Override
    public Block setBlockName(String par1Str)
    {
        super.setBlockName(par1Str);
        return this;
    }
}
