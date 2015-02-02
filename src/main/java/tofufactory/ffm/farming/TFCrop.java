package tofufactory.ffm.farming;

import forestry.api.farming.ICrop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tofufactory.TFVector;

public abstract class TFCrop implements ICrop
{
    protected World world;
    protected TFVector position;

    public TFCrop(World world, TFVector pos)
    {
        this.world = world;
        this.position = pos;
    }

    public List<ItemStack> harvest()
    {
        return this.harvestBlock(this.position);
    }

    protected abstract List<ItemStack> harvestBlock(TFVector pos);
}
