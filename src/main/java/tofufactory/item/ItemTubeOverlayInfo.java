package tofufactory.item;

public class ItemTubeOverlayInfo
{
    public String name;
    public int primaryColor;
    public int secondaryColor;
    public boolean isSecret;

    public ItemTubeOverlayInfo(String name, int primaryColor, int secondaryColor)
    {
        this.primaryColor = 0;
        this.secondaryColor = 0;
        this.isSecret = false;
        this.name = name;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    public ItemTubeOverlayInfo(String name, int primaryColor)
    {
        this(name, primaryColor, 0);
    }

    public ItemTubeOverlayInfo setIsSecret()
    {
        this.isSecret = true;
        return this;
    }
}
