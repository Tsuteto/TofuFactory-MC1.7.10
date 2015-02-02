package tofufactory.item;

public class ItemTofuIngot extends ItemSetBase
{
    public ItemTofuIngot(String[] name)
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
        return "ingot";
    }
}
