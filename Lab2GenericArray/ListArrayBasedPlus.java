import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListArrayBasedPlus<T> extends ListArrayBased<T>
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );
    private final int MAX_LIST = 3;

    // Add an item to the specific location
    @Override
    public void add( int index, T item )
            throws ListIndexOutOfBoundsException
    {
        if ( numItems >= MAX_LIST )
        {
            resize();
        }
        super.add( index, item );
    } // end add

    // Resize
    private void resize()
    {
        T[] temp = ( T[] ) new Object[numItems * 2];
        for ( int i = 0; i < numItems; i++ )
        {
            temp[i] = items[i];
        }
        items = temp;
    } // end resize

    // Reverse the list
    public void reverse()
    {
        for ( int i = 0; i < ( numItems / 2 ); i++ )
        {
            T temp = items[i];
            items[i] = items[numItems - i - 1];
            items[numItems - i - 1] = temp;
        }
    } // end reverse

    // Display all items
    public String toString()
    {
        String result = "";
        for ( int i = 0; i < numItems; i++ )
        {
            if ( items[i] != null )
            {
                result += items[i] + " ";
            }
        }
        return result;
    } // end toString

    public static void main( String[] args ) throws IOException
    {
        ListArrayBasedPlus<Object> listArrayBased = new ListArrayBasedPlus<Object>();

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Insert item to list.");
            System.out.println("    2. Remove item from list.");
            System.out.println("    3. Get item from list.");
            System.out.println("    4. Clear list.");
            System.out.println("    5. Print size and content of list.");
            System.out.println("    6. Reverse list.");
            System.out.println("    7. Exit program.");
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // Insert item to list
                case "1":
                    System.out.println(
                            "You are now inserting an item into" +
                                    "the list" );
                    // enter item
                    System.out.print("    Enter item: ");
                    Object item = bufferedReader.readLine();
                    System.out.println( item );

                    // enter position
                    System.out.print(
                            "    Enter position to insert item in : ");
                    int index = Integer.parseInt(
                            bufferedReader.readLine() );
                    System.out.println( index );

                    if ( index > numItems )
                    {
                        System.out.println(
                                "Position specified is out of range!");
                    }
                    else
                    {
                        listArrayBased.add( index, item );
                        System.out.println(
                                "Item " +
                                        listArrayBased.get( index ) +
                                        " inserted in position " +
                                        index + " in the list.");
                    }
                    break;

                // Remove item from list
                case "2":
                    if ( numItems == 0 )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "    Enter position to remove item from : ");
                        int rIndex = Integer.parseInt(
                                bufferedReader.readLine() );
                        System.out.println( rIndex );
                        if ( rIndex > ( numItems - 1 ) )
                        {
                            System.out.println(
                                    "Position specified is out of range!");
                        }
                        else
                        {
                            System.out.println(
                                    "Item " +
                                            listArrayBased.get( rIndex ) +
                                            " removed from position " +
                                            rIndex + " in the list." );
                            listArrayBased.remove( rIndex );
                        }
                    }
                    break;

                // Get item from list
                case "3":
                    System.out.print(
                            "    Enter position to retrieve item from : ");
                    int myIndex = Integer.parseInt(
                            bufferedReader.readLine() );
                    System.out.println( myIndex );
                    if ( myIndex > ( listArrayBased.size() - 1 ) )
                    {
                        System.out.println(
                                "Position specified is out of range!");
                    }
                    else
                    {
                        System.out.println("Item " +
                                listArrayBased.get( myIndex )  +
                                " retrieved from position " +
                                myIndex + " in the list.");
                    }
                    break;

                // Clear list
                case "4":
                    if ( numItems == 0 )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        listArrayBased.removeAll();
                    }
                    break;

                // Print size and content of list
                case "5":
                    if ( numItems == 0 )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "List of size " +
                                        numItems +
                                        " has the following items : "
                        );
                        System.out.println( listArrayBased.toString() );
                    }
                    break;

                // Reverse list
                case "6":
                    listArrayBased.reverse();
                    break;

                // Exit program
                case "7":
                    System.out.print("Exiting program...Good Bye");
                    System.exit(0 );
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n"
                    );
                    break;
            }
        }
    }
} // end class ListArrayBasedPlus<T>
