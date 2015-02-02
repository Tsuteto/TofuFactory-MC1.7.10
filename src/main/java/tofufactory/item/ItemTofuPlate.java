package tofufactory.item;

public class ItemTofuPlate extends ItemSetBase
{
    public ItemTofuPlate(String[] name)
    {
        super(name);
    }

    @Override
    public boolean isDamageable()
    {
        return false;
    }

    @Override
    public boolean isRepairable()
    {
        return false;
    }

    @Override
    public String getItemSetName()
    {
        return "plate";
    }
}
