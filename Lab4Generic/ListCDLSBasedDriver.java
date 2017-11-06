import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListCDLSBasedDriver
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String args[] ) throws IOException
    {
        ListCDLSBased<Object> listCDLSBased = new ListCDLSBased<Object>();

        while ( true )
        {
            int numItems = listCDLSBased.size();
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Insert item to list.");
            System.out.println("    2. Remove item from list.");
            System.out.println("    3. Get item from list.");
            System.out.println("    4. Clear list.");
            System.out.println("    5. Print size and content of list.");
            System.out.println("    6. Exit program.");
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // Insert item to list
                case "1":
                    System.out.println(
                            "You are now inserting an item into the list.");
                    // enter item
                    System.out.print("    Enter item: ");
                    Object item = bufferedReader.readLine();
                    System.out.println( item );
                    // enter position
                    System.out.print(
                            "    Enter position to insert item in : ");
                    int index =
                            Integer.parseInt( bufferedReader.readLine() );
                    System.out.println( index );
                    if ( index > numItems )
                    {
                        System.out.println(
                                "Position specified is out of range!");
                    }
                    else
                    {
                        listCDLSBased.add( index, item );
                        System.out.println(
                                "Item " + listCDLSBased.get( index ) +
                                        " inserted in position " +
                                        index + " in the list.");
                    }
                    break;

                // Remove item from list
                case "2":
                    int removeIndex;
                    System.out.print(
                            "    Enter position to remove item from : ");
                    removeIndex = Integer.parseInt(
                            bufferedReader.readLine()
                    );
                    System.out.println( removeIndex );

                    if ( numItems == 0 )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        if ( removeIndex > ( numItems - 1 ) )
                        {
                            System.out.println(
                                    "Position specified is out of range!");
                        }
                        else
                        {
                            System.out.println(
                                    "Item " +
                                            listCDLSBased.get( removeIndex ) +
                                            " removed from position " +
                                            removeIndex + " in the list."
                            );
                            listCDLSBased.remove( removeIndex );
                        }
                    }
                    break;

                // Get item from list
                case "3":
                    int myIndex;
                    System.out.print(
                            "    Enter position to retrieve item from : "
                    );
                    myIndex = Integer.parseInt(
                            bufferedReader.readLine() );
                    System.out.println( myIndex );

                    if ( myIndex > ( numItems - 1 ) )
                    {
                        System.out.println(
                                "Position specified is out of range!"
                        );
                    }
                    else
                    {
                        System.out.println(
                                "Item " +
                                        listCDLSBased.get( myIndex )  +
                                        " retrieved from position " +
                                        myIndex + " in the list."
                        );
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
                        listCDLSBased.removeAll();
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
                                        " has the following items : " +
                                        listCDLSBased.toString()
                        );
                        System.out.println();
                    }
                    break;

                // Exit program
                case "6":
                    System.out.print("Exiting program...Good Bye");
                    System.exit(0 );
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n");
                    break;
            }
        }
    }
}
