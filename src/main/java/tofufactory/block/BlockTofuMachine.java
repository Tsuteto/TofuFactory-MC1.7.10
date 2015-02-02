package tofufactory.block;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import tofufactory.TofuFactory;
import tofufactory.entity.EntitySmokeTofuFX;
import tofufactory.proxy.TFTextureStitchEvent;
import tofufactory.tileEntity.TileEntityTofuMachine;

public abstract class BlockTofuMachine extends BlockContainer
{
    private final Random TofuMachineRand = new Random();
    private final boolean isActive;
    private final boolean isIcon;
    private static boolean keepTofuMachineInventory;
    @SideOnly(Side.CLIENT)
    private IIcon TofuMachineIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon TofuMachineIconUnder;
    @SideOnly(Side.CLIENT)
    private IIcon TofuMachineIconFront;

    public BlockTofuMachine(boolean par2, boolean icon)
    {
        super(Material.rock);
        this.isActive = par2;
        this.isIcon = icon;
        if (!isActive)
        {
            this.setCreativeTab(TofuFactory.tabsTofuFactory);
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return Item.getItemFromBlock(this.getIdleBlock());
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            Block block = par1World.getBlock(par2, par3, par4 - 1);
            Block block1 = par1World.getBlock(par2, par3, par4 + 1);
            Block block2 = par1World.getBlock(par2 - 1, par3, par4);
            Block block3 = par1World.getBlock(par2 + 1, par3, par4);
            byte b0 = 3;

            if (block.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 3;
            }

            if (block1.func_149730_j() && !block.func_149730_j())
            {
                b0 = 2;
            }

            if (block2.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 5;
            }

            if (block3.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }

    @Override
    public Block setBlockName(String par1Str)
    {
        super.setBlockName(par1Str);
        return this;
    }

    public boolean isHalloween()
    {
        Calendar cal1 = Calendar.getInstance();
        int month = cal1.get(2) + 1;
        int day = cal1.get(5);
        return month == 10 && day == 31;
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int par1, int par2)
    {
        byte par3 = 0;

        if (par2 == 0)
        {
            par3 = 3;
        }

        return par1 == 0 ? this.TofuMachineIconUnder : (par1 == 1 ? this.TofuMachineIconTop : (par1 == par2 ? this.TofuMachineIconFront : (par1 != par2 + par3 ? this.blockIcon : this.TofuMachineIconFront)));
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IIconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        String d = "";
        String m = TofuFactory.resourceDomain + "machine/";

        if (this.isHalloween())
        {
            d = "Halloween/";
        }

        if (this.isIcon)
        {
            this.blockIcon = par1IconRegister.registerIcon(m + d + this.textureName + "_side");
            this.TofuMachineIconTop = par1IconRegister.registerIcon(m + d + this.textureName + "_top");
        }
        else
        {
            this.blockIcon = par1IconRegister.registerIcon(m + d + "TofuMachine_side_tofu");
            this.TofuMachineIconTop = par1IconRegister.registerIcon(this.isActive ? m + d + "TofuMachine_top_on" : m + d + "TofuMachine_top_off");
        }

        this.TofuMachineIconFront = par1IconRegister.registerIcon(this.isActive ? m + d + this.textureName + "_front_on" : m + d + this.textureName + "_front_off");
        this.TofuMachineIconUnder = par1IconRegister.registerIcon(m + d + "TofuMachine_under");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityTofuMachine tileentityfurnace = (TileEntityTofuMachine)par1World.getTileEntity(par2, par3, par4);

            if (tileentityfurnace != null)
            {
                this.displayGUIBook(par5EntityPlayer, par1World, par2, par3, par4);
            }

            return true;
        }
    }

    public void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        keepTofuMachineInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, this.getRunningBlock());
        }
        else
        {
            par1World.setBlock(par2, par3, par4, this.getIdleBlock());
        }

        keepTofuMachineInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (this.isActive)
        {
            double r = 0.8D + this.TofuMachineRand.nextDouble();
            double t = this.TofuMachineRand.nextDouble() * 2.0D * Math.PI;
            double d0 = (double)par2 + 0.5D;
            double d1 = (double)par3 + 0.3D + this.TofuMachineRand.nextDouble();
            double d2 = (double)par4 + 0.5D;
            double d3 = Math.sin(t) / 64.0D;
            double d4 = 0.07D;
            double d5 = Math.cos(t) / 64.0D;
            EntitySmokeTofuFX entityFX = new EntitySmokeTofuFX(par1World, d0, d1, d2, d3, d4, d5);
            EntitySmokeTofuFX entityFX2 = new EntitySmokeTofuFX(par1World, d0, d1, d2, d3, d4, d5);
            EntitySmokeTofuFX entityFX3 = new EntitySmokeTofuFX(par1World, d0, d1, d2, d3, d4, d5);
            String s = "smokeTofu";

            if (this.isHalloween())
            {
                s = "smokeTofuGlow";
            }

            entityFX.setParticleIcon(TFTextureStitchEvent.getInstance().getIcon("tofufactory:" + s));
            entityFX2.setParticleIcon(TFTextureStitchEvent.getInstance().getIcon("tofufactory:" + s));
            entityFX3.setParticleIcon(TFTextureStitchEvent.getInstance().getIcon("tofufactory:" + s));
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(entityFX);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(entityFX);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(entityFX);
        }
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityTofuMachine)par1World.getTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
        }
    }

    /**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        if (!keepTofuMachineInventory)
        {
            TileEntityTofuMachine tileentityTofuMachine = (TileEntityTofuMachine)par1World.getTileEntity(par2, par3, par4);

            if (tileentityTofuMachine != null)
            {
                for (int j1 = 0; j1 < tileentityTofuMachine.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentityTofuMachine.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.TofuMachineRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.TofuMachineRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.TofuMachineRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.TofuMachineRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.TofuMachineRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.TofuMachineRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.TofuMachineRand.nextGaussian() * f3);
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                par1World.func_147453_f(par2, par3, par4, par5);
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World par1World, int par2, int par3, int par4, int par5)
    {
        return Container.calcRedstoneFromInventory((IInventory)par1World.getTileEntity(par2, par3, par4));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World par1World, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(getIdleBlock());
    }

    public abstract Block getIdleBlock();

    public abstract Block getRunningBlock();

    public abstract void displayGUIBook(EntityPlayer var1, World var2, int var3, int var4, int var5);
}
