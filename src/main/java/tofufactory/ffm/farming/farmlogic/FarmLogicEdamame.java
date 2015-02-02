package tofufactory.ffm.farming.farmlogic;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.farming.Farmables;
import forestry.api.farming.IFarmHousing;
import forestry.api.farming.IFarmable;
import forestry.farming.logic.FarmLogicCrops;
import net.minecraft.util.IIcon;
import tsuteto.tofu.item.TcItems;

public class FarmLogicEdamame extends FarmLogicCrops
{
    public FarmLogicEdamame(IFarmHousing housing)
    {
        super(housing, Farmables.farmables.get("farmEdamame").toArray(new IFarmable[0]));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon()
    {
        return TcItems.edamame.getIconFromDamage(0);
    }

    public String getName()
    {
        return "Edamame";
    }
}
