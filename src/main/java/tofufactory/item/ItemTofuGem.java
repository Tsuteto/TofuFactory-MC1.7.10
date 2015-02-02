package tofufactory.item;

public class ItemTofuGem extends ItemSetBase
{
    public ItemTofuGem(String[] name)
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
        return "gem";
    }
}
