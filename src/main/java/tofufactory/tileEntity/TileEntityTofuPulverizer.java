package tofufactory.tileEntity;

import tofufactory.api.recipes.IMachineRecipe;
import tofufactory.api.recipes.RecipeManagers;
import tofufactory.block.BlockTofuMachine;
import tofufactory.plugin.PluginTofuFactory;

public class TileEntityTofuPulverizer extends TileEntityTofuMachine
{
    public String getMachineName()
    {
        return "container.tofufactory:tfPulverizer";
    }

    public BlockTofuMachine getMachineBlock()
    {
        return (BlockTofuMachine) PluginTofuFactory.tofuPulverizerActive;
    }

    public IMachineRecipe getMachineRecipe()
    {
        return RecipeManagers.pulverizerManager;
    }
}
