// Please note that this code is slightly different from the textbook code
//to reflect the fact that the Node class is implemented using data encapsulation

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ****************************************************
// ListCDLSBased implementation of ADT list.
// ****************************************************
/*
 * Purpose: Data Structure and Algorithms Lab 4 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/17/17
 * Submitted: 10/03/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.09.27
 */
public class ListCDLSBased implements ListInterface
{
    private DNode tail;
    private int numItems;

    public ListCDLSBased()
    {
        tail = null;
        numItems = 0;

    }  // end default constructor

    @Override
    public boolean isEmpty()
    {
        return tail == null;
    }  // end isEmpty

    @Override
    public int size()
    {
        return numItems;
    }  // end size

    // Find a DNode in the list based on the given index.
    private DNode find( int index )
    {
        DNode curr = tail.getNext(); // find head
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
    public void add ( int index, Object item )
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
                    DNode newNode = new DNode( item );
                    tail = newNode;
                }
                else if ( numItems == 1 )
                {
                    DNode curr = tail;
                    DNode newNode = new DNode( item, curr, curr );
                    curr.setBack( newNode );
                    curr.setNext( newNode );
                }
                else
                {
                    DNode head = tail.getNext();
                    DNode newNode = new DNode( item, head, tail );
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
                    DNode last = tail;
                    DNode next = tail.getNext();
                    DNode newNode = new DNode( item, last, next );
                    last.setNext( newNode );
                    next.setBack( newNode );
                    tail = newNode;
                }
                // general cases
                else
                {
                    DNode last = tail;
                    DNode head = tail.getNext();
                    DNode newNode = new DNode( item, head, last );
                    last.setNext( newNode );
                    head.setBack( newNode );
                    tail = newNode;
                }
            }
            // add in the middle of list.
            else
            {
                DNode back = find( index - 1 );
                DNode next = find( index );
                DNode newDNode = new DNode ( item, next, back );
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
    }  // end add

    public Object get(int index)
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < numItems )
        {
            // get reference to node, then data in node
            DNode curr = find( index );
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                    "List index out of bounds exception on get");
        } // end if
    } // end get


    /**
     * Remove an item from specific index.
     * @param index The given index of the item to be removed.
     *
     * */
    public void remove ( int index )
            throws ListIndexOutOfBoundsException
    {
        if ( index >= 0 && index < numItems )
        {
            // remove at beginning of list,
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
                    DNode head = tail.getNext();
                    head = head.getNext();
                    head.setBack( tail );
                }
            }
            // remove at the end of the list,
            else if ( index == numItems )
            {
                if ( numItems == 2 )
                {
                    DNode head = find ( 0 );
                    // make a self loop again
                    head.setNext( tail.getNext() );
                    head.setBack( tail.getBack() );
                    tail = null;
                    tail = head;
                    head = null;
                }
                else
                {
                    DNode back = tail.getBack();
                    DNode head = find( 0 );
                    back.setNext( head );
                    head.setBack( back );
                    tail = back;
                }
            }
            // remove in the middle of the list.
            else
            {
                DNode curr = find( index );
                DNode back = find( index - 1 );
                back.setNext( curr.getNext() );
                back.setBack( back.getBack() );
            }
            numItems--;
        }
        else
        {
            throw new ListIndexOutOfBoundsException
                ("List index out of bounds exception on remove");
        }
    } // end remove

    public void removeAll()
    {
        tail = null;
        numItems = 0;
    } // end removeAll

    public String toString ()
    {
        String result = "";
        DNode curr = tail.getNext();
        for ( int i = 0; i < numItems; i++ )
        {
            result += curr.getItem() + " ";
            curr = curr.getNext();
        }
        return result;
    } // end toString

} // end ListCDLSBased