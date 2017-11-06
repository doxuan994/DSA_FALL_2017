public class ListCDLSBased<T> implements ListInterface<T>
{
    private DNode<T> tail;
    private int numItems;

    public ListCDLSBased()
    {
        tail = null;
        numItems = 0;
    } // end default constructor

    // Check if a list is empty
    @Override
    public boolean isEmpty()
    {
        return tail == null;
    } // end isEmpty

    // Return the size of a list
    @Override
    public int size()
    {
        return numItems;
    } // end size

    // Find a DNode in the list based on the given index.
    // @index The given index for searching.
    private DNode<T> find( int index )
    {
        DNode<T> curr = tail.getNext(); // find head
        if ( index >= 0 && index <= numItems )
        {
            if ( index <= ( numItems / 2 ) )
            {
                for ( int i = 0; i < index; i++ )
                {
                    curr = curr.getNext();
                }
            }
            else
            {
                for ( int i = numItems; i > index; i-- )
                {
                    curr = curr.getBack();
                }
            }
        }
        return curr;
    } // end find

    // Add an item in the specific index position.
    @Override
    public void add( int index, T item )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index <= numItems )
        {
            // add at the beginning of list,
            if ( index == 0 )
            {
                if ( numItems == 0 )
                {
                    // make a self loop
                    DNode<T> newNode = new DNode<T>( item );
                    tail = newNode;
                }
                else if ( numItems == 1 )
                {
                    DNode<T> curr = tail;
                    DNode<T> newNode = new DNode<T>( item, curr, curr );
                    curr.setBack( newNode );
                    curr.setNext( newNode );
                }
                else
                {
                    DNode<T> head = tail.getNext();
                    DNode<T> newNode = new DNode<T>( item, head, tail );
                    head.setBack( newNode );
                    tail.setNext( newNode );
                }
            }
            // add the end of list,
            else if ( index == numItems )
            {
                // only true for adding the second item
                if ( numItems == 1 )
                {
                    DNode<T> last = tail;
                    DNode<T> next = tail.getNext();
                    DNode<T> newNode = new DNode<T>( item, last, next );
                    last.setNext( newNode );
                    next.setBack( newNode );
                    tail = newNode;
                }
                // general cases
                else
                {
                    DNode<T> last = tail;
                    DNode<T> head = tail.getNext();
                    DNode<T> newNode = new DNode<T>( item, head, last );
                    last.setNext( newNode );
                    head.setBack( newNode );
                    tail = newNode;
                }
            }
            // add in the middle of list.
            else
            {
                DNode<T> back = find( index - 1 );
                DNode<T> next = find( index );
                DNode<T> newDNode = new DNode<T> ( item, next, back );
                back.setNext( newDNode );
                next.setBack( newDNode );
            }
            numItems++;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
        } // end if
    }

    // Return an item at a specific position
    @Override
    public T get( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < numItems )
        {
            // get reference to node, then data in node
            DNode<T> curr = find( index );
            T dataItem = curr.getItem();
            return dataItem;
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
        } // end else
    } // end get

    // Remove an item from a specific position
    @Override
    public void remove( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < numItems )
        {
            // remove at beginning of the list,
            if ( index == 0 )
            {
                // and only one item in the list,
                if ( numItems == 1 )
                {
                    // make a self loop
                    tail.setNext( tail.getNext() );
                    tail.setBack( tail.getBack() );
                    tail = null;
                }
                // since more than one then do this,
                else
                {
                    DNode<T> head = tail.getNext();
                    head = head.getNext();
                    head.setBack( tail );
                }
            }
            // remove at the end of the list,
            else if ( index == ( numItems - 1 ) )
            {
                if ( numItems == 2 )
                {
                    DNode<T> head = tail.getNext();
                    // make a self look again
                    head.setNext( tail.getNext() );
                    head.setBack( tail.getBack() );
                    tail = null;
                    tail = head;
                    head = null;
                }
                else
                {
                    DNode<T> back = tail.getBack();
                    DNode<T> head = tail.getNext();
                    back.setNext( head );
                    head.setBack( back );
                    tail = back;
                }
            }
            // remove in the middle of the list.
            else
            {
                DNode<T> curr = find( index );
                DNode<T> back = find( index - 1 );
                back.setNext( curr.getNext() );
                back.setBack( back.getBack() );
            }
            numItems --;
        }
        else
        {
            throw new ListIndexOutOfBoundsException
                    ("List index out of bounds exception on remove");
        }
    }

    // Remove all items
    @Override
    public void removeAll()
    {
        tail = null;
        numItems = 0;
    } // end removeAll

    // Print all items
    @Override
    public String toString()
    {
        String result = "";
        DNode<T> curr = tail.getNext();
        for ( int i = 0; i < numItems; i++ )
        {
            result += curr.getItem() + " ";
            curr = curr.getNext();
        }
        return result;
    } // end toString

} // end class ListCDLSBased
