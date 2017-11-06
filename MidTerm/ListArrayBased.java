public class ListArrayBased<T> implements ListInterface<T>
{
    private final int MAX_LIST = 3;
    private T[] items;
    private int numItems;

    public ListArrayBased()
    {
        items = ( T[] ) new Object[MAX_LIST];
        numItems = 0;
    } // end default constructor

    @Override
    public boolean isEmpty()
    {
        return ( numItems == 0 );
    } // end isEmpty

    @Override
    public int size()
    {
        return numItems;
    } // end size

    @Override
    public void add( int index, T item )
            throws ListIndexOutOfBoundsException
    {
        if ( numItems >= MAX_LIST )
        {
            resize();
        }
        if ( index >= 0 && index <= numItems )
        {
            for ( int pos = numItems-1; pos >= index; pos-- )
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on add");
        } // end if
    } // end add

    // Resize
    private void resize()
    {
        T[] temp = ( T[] ) new Object[numItems * 2];
        for ( int i = 0; i < numItems; i++ )
        {
            temp[i] = items[i];
        }
        items = temp;
    } // end resize

    @Override
    public T get( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < numItems )
        {
            return items[index];
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on get");
        } // end if
    } // end get

    @Override
    public void remove( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < numItems )
        {
            for ( int pos = index+1; pos < numItems; pos++ )
            {
                items[pos-1] = items[pos];
            } // end for
            numItems--;
            items[numItems] = null;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on remove");
        } // end if
    } // end remove

    @Override
    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = ( T[] ) new Object[MAX_LIST];
        numItems = 0;
    } // end removeAll

} // end class ListArrayBased<T>
