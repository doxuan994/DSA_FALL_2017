public class DNode<T>
{
    private T item;
    private DNode<T> back;
    private DNode<T> next;

    public DNode( T item )
    {
        this.item = item;
        back = next = this;
    }

    public DNode( T item, DNode<T> next, DNode<T> back )
    {
        this.item = item;
        this.back = back;
        this.next = next;
    }

    public void setItem( T item )
    {
        this.item = item;
    }

    public  T getItem()
    {
        return item;
    }

    public void setNext( DNode<T> next )
    {
        this.next = next;
    }

    public DNode<T> getNext()
    {
        return next;
    }

    public void setBack( DNode<T> back )
    {
        this.back = back;
    }

    public DNode<T> getBack()
    {
        return back;
    }
} // end class DNode
