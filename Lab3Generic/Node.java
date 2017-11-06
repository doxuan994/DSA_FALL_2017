public class Node<T>
{
    private T item;
    private Node<T> next;

    public Node( T item )
    {
        this.item = item;
        next = null;
    } // end constructor

    public Node( T item, Node<T> next )
    {
        this.item = item;
        this.next = next;
    } // end constructor

    public void setItem( T item )
    {
        this.item = item;
    } // end setItem

    public T getItem()
    {
        return item;
    } // end getItem

    public void setNext( Node<T> next )
    {
        this.next = next;
    } // end setNext

    public Node<T> getNext()
    {
        return next;
    } // end getNext
} // end generic class Node<T>
