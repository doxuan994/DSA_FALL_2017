public class DNode
{
    private Object item;
    private DNode back;
    private DNode next;

    public DNode( Object item )
    {
        this.item = item;
        back = next = this;
    }

    public DNode( Object item, DNode next, DNode back )
    {
        this.item = item;
        this.back = back;
        this.next = next;
    }

    public void setItem( Object item )
    {
          this.item = item;
    }

    public Object getItem()
    {
        return item;
    }

    public void setNext( DNode next )
    {
        this.next = next;
    }

    public DNode getNext()
    {
        return next;
    }

    public void setBack( DNode back )
    {
        this.back = back;
    }

    public DNode getBack() { return back; }
}
