package tofufactory.recipe;

// I seal down Greg features for now (╯•﹏•╰)
public class RecipeManagerGreg
{
    public static void registerRecipes()
    {
        registeGrinder();
        registeCentrifuge();
    }

    private static void registeGrinder()
    {
//        GregTech_API.sRecipeAdder.addGrinderRecipe(new ItemStack(TcItems.materials, 1, 1), GT_ModHandler.getWaterCell(0), new ItemStack(PluginTF.TofuDust, 2, 0), GregTech_API.getGregTechItem(1, 1, 20), (ItemStack)null, (ItemStack)null);
    }

    private static void registeCentrifuge()
    {
//        GregTech_API.sRecipeAdder.addCentrifugeRecipe(new ItemStack(PluginTF.TofuDust, 1, 0), 2, new ItemStack(PluginIC2.TFCell, 1, 0), new ItemStack(PluginTF.BakingSoda, 1), GregTech_API.getGregTechItem(1, 1, 36), new ItemStack(PluginIC2.TFCell, 1, 5), 50);
//        GregTech_API.sRecipeAdder.addCentrifugeRecipe(new ItemStack(TcItems.materials, 1, 1), 2, new ItemStack(PluginIC2.TFCell, 2, 0), new ItemStack(PluginTF.BakingSoda, 2), GregTech_API.getGregTechItem(4, 1, 36), (ItemStack)null, 50);
//
//        if (TFPluginManager.modAppeng && TFConfig.AppliedEnergistics)
//        {
//            ItemStack meCable = AEApi.instance().parts().partCableCovered.stack(AEColor.White, 1);
//            meCable.stackSize = 4;
//            GregTech_API.sRecipeAdder.addWiremillRecipe(AEApi.instance().materials().materialCertusQuartzCrystal.stack(1), meCable, 10, 500);
//        }
    }
}
