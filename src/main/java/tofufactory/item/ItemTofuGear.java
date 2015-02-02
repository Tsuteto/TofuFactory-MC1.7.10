package tofufactory.item;

public class ItemTofuGear extends ItemSetBase
{
    public ItemTofuGear(String[] name)
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
        return "gear";
    }
}
