package tofufactory.ffm.farming.farmlogic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.farming.Farmables;
import forestry.api.farming.IFarmHousing;
import forestry.api.farming.IFarmable;
import forestry.farming.logic.FarmLogicCrops;
import net.minecraft.util.IIcon;
import tsuteto.tofu.item.TcItems;

public class FarmLogicSoybean extends FarmLogicCrops
{
    public FarmLogicSoybean(IFarmHousing housing)
    {
        super(housing, Farmables.farmables.get("farmSoybean").toArray(new IFarmable[0]));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return TcItems.soybeans.getIconFromDamage(0);
    }

    public String getName()
    {
        return "Soybean";
    }
}
