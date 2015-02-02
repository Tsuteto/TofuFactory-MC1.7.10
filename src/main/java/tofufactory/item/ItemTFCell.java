package tofufactory.item;

public class ItemTFCell extends ItemSetBase
{
    public ItemTFCell(String[] name)
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
        return "cell";
    }

}
