import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * Purpose: Data Structure and Algorithms Lab 2 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 09/18/17
 * Submitted:  09/19/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.09.13
 */
public class ListArrayListBasedPlus extends ListArrayListBased {

    private static final int MAX_LIST = 3;
    private Object[] items;
    private static int numItems;

    public ListArrayListBasedPlus() {
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    // 6 OLD METHODS
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
    @Override
    public void remove(int index)
            throws ListIndexOutOfBoundsException {
        if ( index >= 0 && index < numItems ) {
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

    // Add an object at the end of the list
    // A method is modified from the add method in ListArrayBased
    public void add(int index, Object obj) {
        if ( numItems >= items.length ) {
            // copy old items to new array of items,
            // require the use of additional storage
            items =
                    Arrays.copyOf(
                            items, items.length * 2
                    );
        }
        // add item
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

    // 2 NEW METHODS
    // reserve list
    public void reverseTheList() {
        for ( int i = 0; i < numItems / 2; i++ ) {
            Object temp = items[i];
            items[i] = items[ numItems - i - 1 ];
            items[ numItems - i - 1 ] = temp;
        }
        System.out.println("List reversed");
    }

    // Custom toString() Method.
    public String toString() {
        String toStringResult = "";
        for (int i = 0; i < numItems; i++) {
            if ( items[i] != null ) {
                toStringResult = toStringResult +
                        items[i] +
                        " ";
            }
        }
        return toStringResult;
    }


    // The main class for testing purpose only
    public static void main( String args[] ) throws IOException {
        // The BufferedReader field is for testing purpose only
        BufferedReader bufferedReader =
                new BufferedReader( new InputStreamReader( System.in ) );

        ListArrayListBasedPlus ml = new ListArrayListBasedPlus();

        // Local data fields
        int number;
        int dummyCounter = 0;

        System.out.println();
        System.out.println("Select from the following menu: ");
        System.out.println("    1. Insert item to list.");
        System.out.println("    2. Remove item from list.");
        System.out.println("    3. Get item from list.");
        System.out.println("    4. Clear list.");
        System.out.println("    5. Print size and content of list.");
        System.out.println("    6. Reverse list.");
        System.out.println("    7. Exit program.");
        System.out.print("Make your menu selection now: ");
        // first number is inputted
        number = Integer.parseInt( bufferedReader.readLine() );
        System.out.println( number );

        // a loop for inputting data
        while ( number != 0 ) {

            if ( dummyCounter == 1 ) {

                System.out.println();
                System.out.println(
                        "Select from the following menu: "
                );
                System.out.println(
                        "    1. Insert item to list."
                );
                System.out.println(
                        "    2. Remove item from list."
                );
                System.out.println(
                        "    3. Get item from list."
                );
                System.out.println(
                        "    4. Clear list."
                );
                System.out.println(
                        "    5. Print size and content of list."
                );
                System.out.println(
                        "    6. Reverse list."
                );
                System.out.println(
                        "    7. Exit program."
                );
                System.out.print(
                        "Make your menu selection now: "
                );
                number =
                        Integer.parseInt(
                                bufferedReader.readLine()
                        );
                System.out.println( number );

            }

            switch (number) {

                // insert item to list
                case 1:
                    int index;
                    Object obj;

                    System.out.println(
                            "You are now inserting an item into the list."
                    );

                    System.out.print("    Enter item: ");
                    obj = bufferedReader.readLine();
                    System.out.println( obj );

                    System.out.print(
                            "    Enter position to insert item in : "
                    );
                    index =
                            Integer.parseInt( bufferedReader.readLine()
                            ) ;
                    System.out.println( index );

                    if ( index > numItems ) {
                        System.out.println(
                                "Position specified is out of range!"
                        );
                    } else {
                        ml.add(index, obj);
                        System.out.println(
                                "Item " +
                                        ml.get( index ) +
                                        " inserted in position " +
                                        index + " in the list."
                        );
                    }

                    break;

                // remove item from list
                case 2:
                    int newIndex;

                    System.out.print(
                            "    Enter position to remove item from : "
                    );
                    newIndex = Integer.parseInt(
                            bufferedReader.readLine()
                    );
                    System.out.println( newIndex );

                    if ( newIndex > ( ml.size() - 1 ) ) {
                        System.out.println(
                                "Position specified is out of range!"
                        );
                    } else {
                        System.out.println(
                                "Item " +
                                        ml.get( newIndex ) +
                                        " removed from position " +
                                        newIndex +
                                        " in the list."
                        );
                        ml.remove( newIndex );
                    }

                    break;

                // get item from list
                case 3:
                    int myIndex;
                    System.out.print(
                            "    Enter position to retrieve item from : ");
                    myIndex = Integer.parseInt(
                            bufferedReader.readLine()
                    );
                    System.out.println( myIndex );

                    if ( myIndex > ( ml.size() - 1 ) ) {
                        System.out.println(
                                "Position specified is out of range!");
                    } else {
                        System.out.println("Item " +
                                ml.get( myIndex )  +
                                " retrieved from position " +
                                myIndex + " in the list.");
                    }
                    break;

                // clear list
                case 4:

                    ml.removeAll();
                    break;

                // print size and content of list
                case 5:
                    if ( ml.isEmpty() ) {
                        System.out.println("List is empty.");
                    } else {
                        System.out.print(
                                "List of size " +
                                ml.size() +
                                " has the following items : "
                        );
                        for ( int i = 0; i < numItems; i++ ) {
                            System.out.print( ml.get(i) + " " );
                        }
                        System.out.println();
                    }
                    break;

                // reverse list
                case 6:
                    ml.reverseTheList();
                    break;

                // exit program
                case 7:
                    System.out.print("Exiting program...Good Bye");
                    System.exit(0);
                    break;
            }

            dummyCounter = 1;

        } // end while

    }
}
