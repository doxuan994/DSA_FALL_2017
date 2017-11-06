/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted:  10/10/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.04
 */
public class Stack<T> implements StackInterface<T>
{
    private T[] items;
    private int top;

    public Stack()
    {
        items = ( T[] ) new Object[3];
        top = -1;
    }

    @Override
    public boolean isEmpty()
    {
        return ( top == -1 );
    } // end isEmpty

    // Adds an item to the top of a stack.
    // Precondition: newItem is the item to be added.
    // Post condition: If insertion is successful, newItem
    // is on the top of the stack.
    // Exception: Some implementations may throw
    // StackException when newItem cannot be placed on
    // the stack.
    @Override
    public void push( T newItem ) throws StackException
    {
        if ( top == ( items.length - 1 ) )
        {
            resize();
        }
        items[++top] = newItem;
    } // end push

    private void resize()
    {
        T[] temp = ( T[] ) new Object[items.length * 2];
        for ( int i = 0; i < items.length; i++ )
        {
            temp[i] = items[i];
        }
        items = temp;
    } // end resize

    // Removes the top of a stack.
    // Precondition: None.
    // Post condition: If the stack is not empty, the item
    // that was added most recently is removed from the
    // stack.
    // Exception: Throws StackException if the stack is
    // empty.
    @Override
    public T pop() throws StackException
    {
        T result = null;
        if ( top != -1 )
        {
            result = items[top];
            items[top--] = null;
        }
        return result;
    } // end pop

    @Override
    public void popAll()
    {
        items = ( T[] ) new Object[3];
        top = -1;
    } // end popAll

    // Retrieves the top of a stack.
    // Precondition: None.
    // Post condition: If the stack is not empty, the item
    // that was added most recently is returned. The
    // stack is unchanged.
    // Exception: Throws StackException if the stack is
    // empty.
    @Override
    public T peek() throws StackException
    {
        T result = null;
        if ( top != -1 )
        {
            result = items[top];
        }
        return result;
    } // end peek

    @Override
    public String toString()
    {
        String result = "";
        for(int i = 0; i <= top; i++)
        {
            result += items[i] + " ";
        }
        return result;
    } // end toString

} // end class Stack<T>