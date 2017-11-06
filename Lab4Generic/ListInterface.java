public interface ListInterface<T>
{
    // Check if a list is empty
    public boolean isEmpty();

    // Return the size of a list
    public int size();

    // Add an item to a specific position
    public void add( int index, T item )
            throws ListIndexOutOfBoundsException;

    // Return an item at a specific position
    public T get( int index )
            throws ListIndexOutOfBoundsException;

    // Remove an item from a specific position
    public void remove( int index )
            throws ListIndexOutOfBoundsException;

    // Remove all items
    public void removeAll();

    // Print all items
    public String toString();

} // end interface ListInterface<T>
