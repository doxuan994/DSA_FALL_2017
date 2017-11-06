// Please note that this code is slightly different from the textbook code
//to reflect the fact that the Node class is implemented using data encapsulation

// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************

/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/06/17
 * Submitted:  10/10/17
 * Comment: Redone.
 * @author: Xuan Do
 * @version: 2017.09.20
 */
public class MyListReferenceBased implements ListInterface
{
    // reference to linked list of items
    protected Node head;

    public MyListReferenceBased()
    {
        head = null;
    }  // end default constructor

    @Override
    public boolean isEmpty()
    {
        return ( head == null );
    }  // end isEmpty

    @Override
    public int size()
    {
        Node node = head;
        int numItems = 0;
        while ( node != null )
        {
            numItems++;
            node = node.getNext();
        }
        return numItems;
    }  // end size

    public Node find( int index )
    {
        // --------------------------------------------------
        // Locates a specified node in a linked list.
        // Precondition: index is the number of the desired
        // node. Assumes that 0 <= index <= numItems
        // Post condition: Returns a reference to the desired
        // node.
        // --------------------------------------------------
        Node curr = head;
        for (int skip = 0; skip < index; skip++)
        {
            curr = curr.getNext();
        } // end for
        return curr;
    } // end find

    @Override
    public void add( int index, Object item )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < size()+1 )
        {
            if (index == 0)
            {
                // insert the new node containing item at
                // beginning of list
                Node newNode = new Node(item, head);
                head = newNode;
            }
            else
            {
                Node prev = find(index-1 );
                // insert the new node containing item after
                // the node that prev references
                Node newNode =
                        new Node( item, prev.getNext() );
                prev.setNext(newNode);
            } // end if
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on add");
        } // end if
    }  // end add

    @Override
    public Object get( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < size() )
        {
            // get reference to node, then data in node
            Node curr = find( index );
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
        } // end if
    } // end get

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
            }
            else
            {
                Node prev = find(index-1 );
                // delete the node after the node that prev
                // references, save reference to node
                Node curr = prev.getNext();
                prev.setNext( curr.getNext() );
            }
        } // end if
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on remove");
        } // end else
    }   // end remove

    @Override
    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        head = null;
    } // end removeAll

    // an additional toString method
    public String toString()
    {
        String toStringList = "";
        Node currNode = head;
        while ( currNode != null )
        {
            toStringList += currNode.getItem() + " " ;
            currNode = currNode.getNext();
        }
        return toStringList;
    }

} // end ListReferenceBased