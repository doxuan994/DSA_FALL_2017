import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListArrayListBasedPlus<T> extends ListArrayListBased<T>
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    // Reverse the list
    public void reverse()
    {

    } // end reverse


    public static void main( String[] args ) throws IOException
    {
        ListArrayListBased<Object> listArrayListBased =
                new ListArrayListBasedPlus<Object>();
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
                                    " the list.");
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

                    listArrayListBased.add( index, item );
                    System.out.println(
                            "Item " +
                                    listArrayListBased.get( index ) +
                                    " inserted in position " +
                                    index + " in the list.");
                    break;

                // Remove item from list
                case "2":
                    if ( listArrayListBased.isEmpty() )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "    Enter position to remove item from : ");
                        int rIndex = Integer.parseInt(
                                bufferedReader.readLine() );
                        if ( rIndex > ( listArrayListBased.size() - 1 ) )
                        {
                            System.out.println(
                                    "Position specified is out of range!");
                        }
                        else
                        {
                            System.out.println(
                                    "Item " +
                                            listArrayListBased.get( rIndex ) +
                                            " removed from position " +
                                            rIndex + " in the list." );
                            listArrayListBased.remove( rIndex );
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
                    if ( myIndex > ( listArrayListBased.size() - 1 ) )
                    {
                        System.out.println(
                                "Position specified is out of range!");
                    }
                    else
                    {
                        System.out.println("Item " +
                                listArrayListBased.get( myIndex )  +
                                " retrieved from position " +
                                myIndex + " in the list.");
                    }
                    break;

                // Clear list
                case "4":
                    if ( listArrayListBased.isEmpty() )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        listArrayListBased.removeAll();
                    }
                    break;

                // Print size and content of list
                case "5":
                    if ( listArrayListBased.isEmpty() )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "List of size " +
                                        listArrayListBased.size() +
                                        " has the following items : ");
                        System.out.println( listArrayListBased.toString() );
                    }
                    break;

                // Reverse list
                case "6":

                    break;

                // Exit program
                case "7":
                    System.out.print("Exiting program...Good Bye");
                    System.exit(0 );
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n");
                    break;

            } // end switch

        } // end while

    } // end main

} // end class ListArrayListBasedPlus<T>
