package tofufactory.pipe;

import buildcraft.api.core.IIconProvider;
import buildcraft.transport.Pipe;
import buildcraft.transport.PipeTransportPower;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import tofufactory.TFPipeIconProvider;
import tofufactory.plugin.PluginBC;

public class PipePowerTofuIshi extends Pipe<PipeTransportPower>
{
    public PipePowerTofuIshi(Item item)
    {
        super(new PipeTransportPower(), item);
        this.transport.initFromPipe(this.getClass());
    }

    public IIconProvider getIconProvider()
    {
        return PluginBC.pipeIconProvider;
    }

    public int getIconIndex(ForgeDirection direction)
    {
        return TFPipeIconProvider.TYPE.PipePowerTofuIshi.ordinal();
    }
}
