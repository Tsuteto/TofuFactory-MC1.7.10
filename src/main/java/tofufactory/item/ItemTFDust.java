package tofufactory.item;

public class ItemTFDust extends ItemSetBase
{

    public ItemTFDust(String[] name)
    {
        super(name);
    }

    public boolean isDamageable()
    {
        return false;
    }

    public boolean isRepairable()
    {
        return false;
    }

    @Override
    public String getItemSetName()
    {
        return "dust";
    }

}
