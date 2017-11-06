public class Queue<T> implements QueueInterface<T>
{
    protected T[] items;
    protected int front;
    protected int back;
    protected int numItems;

    public Queue()
    {
        items = ( T[] ) new Object[3];
        front = 0;
        back = 0;
        numItems = 0;
    }

    // Determines whether a queue is empty.
    // Precondition: None.
    // Post condition: Returns true if the queue is empty;
    // otherwise returns false.
    @Override
    public boolean isEmpty()
    {
        return ( numItems == 0 );
    }

    // Adds an item at the back of a queue.
    // Precondition: newItem is the item to be inserted.
    // Post condition: If the operation was successful, newItem
    // is at the back of the queue. Some implementations
    // may throw QueueException if newItem cannot be added
    // to the queue.
    @Override
    public void enqueue ( T newItem )
            throws QueueException
    {
        if ( numItems == items.length )
        {
            resize();
        }
        items[back] = newItem;
        back = ( back + 1 ) % items.length;
        numItems++;
    }

    public void resize()
    {
        T[] temp = ( T[] ) new Object[items.length * 2];
        for ( int i = 0; i < items.length; i++ )
        {
            temp[i] = items[front];
            front = ( front + 1 ) % items.length;
        }
        front = 0;
        back = numItems;
        items = temp;
    }

    // Retrieves and removes the front of a queue.
    // Precondition: None.
    // Post condition: If the queue is not empty, the item that
    // was added to the queue earliest is removed. If the queue is
    // empty, the operation is impossible and QueueException is thrown.
    @Override
    public T dequeue() throws QueueException
    {
        T item = items[front];
        if ( numItems != 0 )
        {
            items[front] = null;
            front = ( front + 1 ) % items.length;
            numItems--;
        }
        return item;
    }

    // Removes all items of a queue.
    // Precondition: None.
    // Post condition: The queue is empty.
    @Override
    public void dequeueAll()
    {
        items = ( T[] ) new Object[3];
        front = 0;
        back = 0;
        numItems = 0;
    }

    // Retrieves the item at the front of a queue.
    // Precondition: None.
    // Post condition: If the queue is not empty, the item
    // that was added to the queue earliest is returned.
    // If the queue is empty, the operation is impossible
    // and QueueException is thrown.
    @Override
    public T peek() throws QueueException
    {
        T result = null;
        if ( numItems != 0 )
        {
            result = items[front];
        }
        return result;
    }

    // Returns a string representation of this queue.
    public String toStringT()
    {
        StringBuilder s = new StringBuilder();
        for ( T item : items )
        {
            s.append( item );
            s.append(' ');
        }
        return s.toString();
    }

    @Override
    public String toString()
    {
        String result = "";
        int temp = front;

        for ( int i = 0; i < numItems; i++ )
        {
            result += items[temp] + " ";
            temp = ( temp + 1 ) % items.length;
        }
        return result;
    }
}
