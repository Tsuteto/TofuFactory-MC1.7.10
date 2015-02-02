package tofufactory.tileEntity;

import tofufactory.api.recipes.IMachineRecipe;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.block.BlockTofuMachine;
import tofufactory.plugin.PluginTofuFactory;

public class TileEntityTofuCompactor extends TileEntityTofuMachine
{
    public String getMachineName()
    {
        return "container.tofufactory:tfCompactor";
    }

    public BlockTofuMachine getMachineBlock()
    {
        return (BlockTofuMachine) PluginTofuFactory.tofuCompactorActive;
    }

    public IMachineRecipe getMachineRecipe()
    {
        return RecipeManagers.compactorManager;
    }
}
