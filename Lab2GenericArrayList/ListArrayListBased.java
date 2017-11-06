import java.util.ArrayList;

public class ListArrayListBased<T> implements ListInterface<T>
{
    protected ArrayList<T> items;

    public ListArrayListBased()
    {
        items = new ArrayList<T>();
    } // end default constructor

    @Override
    public boolean isEmpty()
    {
        return ( items.size() == 0 );
    } // end isEmpty

    @Override
    public int size()
    {
        return items.size();
    } // end size

    @Override
    public void add( int index, T item )
            throws ListIndexOutOfBoundsException
    {
        items.add( index, item );

    } // end add

    @Override
    public T get( int index )
    {
        return items.get( index );
    } // end get

    @Override
    public void remove( int index )
    {
        items.remove( index );
    } // end remove

    @Override
    public void removeAll()
    {
        items = new ArrayList<T>();
    } // end removeAll

    // Display all items
    public String toString()
    {
        String result = "";
        for ( int i = 0; i < size(); i++ )
        {
            result += items.get(i) + " ";
        }
        return result;
    } // end toString

} // end class ListArrayListBased<T>
