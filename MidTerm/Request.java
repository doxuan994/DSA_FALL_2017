public class Request
{
    private String name;
    private int basketball;
    private int baseball;
    private int football;

    public Request( int bask, int base, int foot)
    {
        basketball = bask;
        baseball = base;
        football = foot;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String newName )
    {
        name = newName;
    }

    public int getBasketball()
    {
        return basketball;
    }

    public void setBasketball( int bask )
    {
        baseball = bask;
    }

    public int getBaseball()
    {
        return baseball;
    }

    public void setBaseball( int base )
    {
        baseball = base;
    }

    public int getFootball()
    {
        return football;
    }

    public void setFootball( int foot )
    {
        football = foot;
    }
}
