// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/07/17
 * Submitted:
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.09.13
 */
public class ListArrayBased implements ListInterface
{
    private static final int MAX_LIST = 3;
    protected static Object []items;  // an array of list items
    protected static int numItems;  // number of items in list

    public ListArrayBased()
    {
        items = new Object[MAX_LIST];
        numItems = 0;
    }  // end default constructor

    @Override
    public boolean isEmpty()
    {
        return ( numItems == 0 );
    } // end isEmpty

    @Override
    public int size()
    {
        return numItems;
    }  // end size

    @Override
    public void add( int index, Object item )
            throws  ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index <= numItems )
        {
            // make room for new element by shifting all items
            // at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for ( int pos = numItems-1; pos >= index; pos-- )
                //textbook code modified to eliminate logic
                // error causing ArrayIndexOutOfBoundsException
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
        }  // end if
    } //end add

    @Override
    public Object get( int index )
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
        }  // end if
    } // end get

    @Override
    public void remove(int index)
            throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++)
                //textbook code modified to eliminate logic error
                // causing ArrayIndexOutOfBoundsException
            {
                items[pos-1] = items[pos];
            }  // end for
            numItems--;
            items[numItems] = null; //fixes memory leak
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove

    @Override
    public void removeAll()
    {
        // Creates a new array; marks old array for
        // garbage collection.
        items = new Object[MAX_LIST];
        numItems = 0;
    } // end removeAll

    public String toString()
    {
        String result = "";
        for ( int i = 0; i < numItems; i++ )
        {
            if ( items[i] != null )
            {
                result += items[i] + " ";
            }
        }
        return result;
    }
}