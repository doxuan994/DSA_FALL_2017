public class MyListReferenceBased<T> implements ListInterface<T>
{
    protected Node<T> head;
    public MyListReferenceBased()
    {
        head = null;
    } // end default constructor

    // Check if a list is empty
    @Override
    public boolean isEmpty()
    {
        return ( head == null ) ;
    } // end isEmpty

    // Return the size of a list
    @Override
    public int size()
    {
        Node<T> node = head;
        int numItems = 0;
        while ( node != null )
        {
            numItems++;
            node = node.getNext();
        }
        return numItems;
    } // end size

    public Node<T> find( int index )
    {
        // --------------------------------------------------
        // Locates a specified node in a linked list.
        // Precondition: index is the number of the desired
        // node. Assumes that 0 <= index <= numItems
        // Post condition: Returns a reference to the desired
        // node.
        // --------------------------------------------------
        Node<T> curr = head;
        for ( int skip = 0; skip < index; skip++ )
        {
            curr = curr.getNext();
        } // end for
        return curr;
    } // end find

    // Add an item to a specific position
    @Override
    public void add( int index, T item )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < size()+1 )
        {
            if ( index == 0 )
            {
                // insert the new node containing item at
                // beginning of list
                Node<T> newNode = new Node<T>( item, head );
                head = newNode;
            }
            else
            {
                Node<T> prev = find( index-1 );
                // insert the new node containing item after
                // the node that prev references
                Node<T> newNode =
                        new Node<T>( item, prev.getNext() );
                prev.setNext( newNode );
            } // end if
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
        } // end if
    } // end add

    // Return an item at a specific position
    @Override
    public T get( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < size() )
        {
            // get reference to node, then data in node
            Node<T> curr = find( index );
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
        if ( index >= 0 && index < size() )
        {
            if ( index == 0 )
            {
                // delete the first node from the list
                head = head.getNext();
            } // end if
            else
            {
                Node<T> prev = find( index - 1 );
                // delete the node after the node that prev
                // references, save reference to node
                Node<T> curr = prev.getNext();
                prev.setNext( curr.getNext() );
            } // end else
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on remove");
        } // end else
    } // end remove

    // Remove all items
    @Override
    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        head = null;
    }

    // Print all items
    @Override
    public String toString()
    {
        String result = "";
        Node currNode = head;
        while ( currNode != null )
        {
            result += currNode.getItem() + " " ;
            currNode = currNode.getNext();
        }
        return result;
    } // end toString
} // end class MyListReferenceBased<T>
