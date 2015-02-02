package tofufactory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import tofufactory.tileEntity.TileEntityTofuMachine;

public abstract class GuiTofuMachine extends GuiContainer
{
    private final TileEntityTofuMachine tofuMachineInventory;

    public GuiTofuMachine(ContainerTofuMachine par1ContainerTofuMachine, TileEntityTofuMachine par2TileEntityTofuMachine)
    {
        super(par1ContainerTofuMachine);
        this.tofuMachineInventory = par2TileEntityTofuMachine;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        String s = this.tofuMachineInventory.isInvNameLocalized() ? this.tofuMachineInventory.getInventoryName() : I18n.format(this.tofuMachineInventory.getInventoryName());
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(this.getResourceLocation());
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.tofuMachineInventory.isBurning())
        {
            i1 = this.tofuMachineInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = this.tofuMachineInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }

    protected ResourceLocation getResourceLocation()
    {
        return new ResourceLocation("tofufactory", "textures/gui/" + this.getGuiImgName() + ".png");
    }

    protected abstract String getGuiImgName();
}
