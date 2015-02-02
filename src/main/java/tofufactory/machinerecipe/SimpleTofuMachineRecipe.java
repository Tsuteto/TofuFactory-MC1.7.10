package tofufactory.machinerecipe;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class SimpleTofuMachineRecipe extends TofuMachineRecipe
{
    protected final Map<Integer, ItemStack> ProcessingList = Maps.newHashMap();
    //protected final Map experienceList = new HashMap();
    protected final HashMap<List<Integer>, ItemStack> metaProcessingList = Maps.newHashMap();
    protected final HashMap<List<Integer>, Float> metaExperience = Maps.newHashMap();


    public void addRecipe(ItemStack input, ItemStack output)
    {
        this.metaProcessingList.put(Arrays.asList(Item.getIdFromItem(input.getItem()), input.getItemDamage()), output);
        this.metaExperience.put(Arrays.asList(Item.getIdFromItem(input.getItem()), input.getItemDamage()), 1.0F);
    }

    public ItemStack getResultFromMetaItem(ItemStack input)
    {
        return this.metaProcessingList.get(Arrays.asList(Item.getIdFromItem(input.getItem()), input.getItemDamage()));
    }

    public ItemStack getResultFromItem(ItemStack input)
    {
        return this.ProcessingList.get(Item.getIdFromItem(input.getItem()));
    }
}
