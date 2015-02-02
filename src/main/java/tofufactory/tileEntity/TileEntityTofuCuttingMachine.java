package tofufactory.tileEntity;

import tofufactory.api.recipes.IMachineRecipe;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.block.BlockTofuMachine;
import tofufactory.plugin.PluginTofuFactory;

public class TileEntityTofuCuttingMachine extends TileEntityTofuMachine
{
    public String getMachineName()
    {
        return "container.tofufactory:tfCuttingMachine";
    }

    public BlockTofuMachine getMachineBlock()
    {
        return (BlockTofuMachine) PluginTofuFactory.tofuCuttingMachineActive;
    }

    public IMachineRecipe getMachineRecipe()
    {
        return RecipeManagers.cuttingMachineManager;
    }
}
