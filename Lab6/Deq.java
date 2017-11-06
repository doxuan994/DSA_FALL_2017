/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted:  10/17/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.09
 */
public class Deq<T> extends Queue<T>
        implements ExtendedQueueInterface<T>
{
    @Override
    public void enqueueFirst( T newItem )
            throws ExtendedQueueException
    {
        if ( numItems == items.length )
        {
            super.resize();
        }
        front = ( front + items.length - 1 ) % items.length;
        items[front] = newItem;
        numItems++;
    }

    public T dequeueLast()
            throws ExtendedQueueException
    {
        T item = null;
        if ( numItems != 0 )
        {
            item = items[back];
            back = ( back + items.length - 1 ) % items.length;
            items[back] = null;
            numItems--;
        }
        return item;
    }

    public T peekLast()
            throws ExtendedQueueException
    {
        T result = null;
        if ( numItems != 0 )
        {
            result = items[( back + items.length - 1 ) % items.length];
        }
        return result;
    }
} //  end class Deq
