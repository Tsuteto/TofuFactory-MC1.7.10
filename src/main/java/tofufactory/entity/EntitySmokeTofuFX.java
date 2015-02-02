package tofufactory.entity;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

public class EntitySmokeTofuFX extends EntityFX
{
    private double orginalPosY;
    private double orginalPosX;
    private double orginalPosZ;

    public EntitySmokeTofuFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World, par2, par4, par6);
        this.orginalPosX = par2;
        this.orginalPosY = par4;
        this.orginalPosZ = par6;
        this.motionX = par8;
        this.motionY = par10;
        this.motionZ = par12;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if ((this.posY > this.orginalPosY + 5.0D || Math.abs(this.posX - this.orginalPosX) > 2.0D || Math.abs(this.posZ - this.orginalPosZ) > 2.0D) && this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    public int getFXLayer()
    {
        return 2;
    }
}
