// ********************************************************
// ArrayList-based implementation of the ADT list.
// *********************************************************
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 09/18/17
 * Submitted:  09/19/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.09.13
 */
public class ListArrayListBased implements ListInterface {

    private static final int MAX_LIST = 3;
    private Object[] items;
    private int numItems;

    public ListArrayListBased() {
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    @Override
    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    @Override
    public int size()
    {
        return numItems;
    }  // end size

    @Override
    public void removeAll() {
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    @Override
    public Object get(int index)
            throws ListIndexOutOfBoundsException {
        if (index >= 0 && index < numItems) {
            return items[index];
        } else {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on get");
        }
    }

    // Add an item to the specified location
    @Override
    public void add(int index, Object obj) {
        if (numItems >= MAX_LIST) {
            throw new ListException("ListException on add");
        }
        if (index >= 0 && index <= numItems) {
            for (int pos = numItems-1; pos >= index; pos--) {
                items[pos+1] = items[pos];
            }
            items[index] = obj;
            numItems++;
        } else {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on add");
        }
    }

    @Override
    public void remove(int index) {
        if(index >= 0 && index < numItems) {
            Object obj = items[index];
            items[index] = null;
            int temp = index;
            while (temp < numItems) {
                items[temp] = items[temp + 1];
                items[temp + 1] = null;
                temp++;
            }
            numItems--;
        } else {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                    "ListIndexOutOfBoundsException on remove");
        }
    }
}
