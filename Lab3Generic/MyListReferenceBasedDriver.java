import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyListReferenceBasedDriver
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    // Find the largest item in a list
    private static Node<Object> max( Node<Object> head )
    {
        if ( head == null ) return null;
        if ( head.getNext() == null ) return head;
        Node<Object> max = head;

        for ( Node<Object> temp = head;
              temp.getNext() != null;
              temp = temp.getNext() )
        {
            String curr = ( String ) temp.getItem();
            String next = ( String ) temp.getNext().getItem();
            // ---------------------------------------------
            // Investigate the value that the String class
            // compareTo method returns.
            // ---------------------------------------------
            if ( curr.compareTo( next ) < 0 )
            {
                max = temp.getNext();
            }
        }
        return max;
    }

    public static void main (String[] args) throws IOException
    {
        MyListReferenceBased<Object> singlyLinkedList =
                new MyListReferenceBased<Object>();

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Insert item to list.");
            System.out.println("    2. Remove item from list.");
            System.out.println("    3. Get item from list.");
            System.out.println("    4. Clear list.");
            System.out.println("    5. Print size and content of list.");
            System.out.println("    6. Delete largest item in the list.");
            System.out.println("    7. Reverse the list.");
            System.out.println("    8. Exit program.");
            System.out.println("    9. Investigate compareTo method");
            System.out.println("    10. Find largest item in the list.");
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // Add item to list
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
                            Integer.parseInt( bufferedReader.readLine() ) ;
                    System.out.println( index );
                    if ( index > singlyLinkedList.size() )
                    {
                        System.out.println(
                                "Position specified is out of range!"
                        );
                    }
                    else
                    {
                        singlyLinkedList.add( index, item );
                        System.out.println(
                                "Item " +
                                        singlyLinkedList.get( index ) +
                                        " inserted in position " +
                                        index + " in the list."
                        );
                    }
                    break;

                // Remove item from list
                case "2":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "    Enter position to remove item from : "
                        );
                        int rIndex = Integer.parseInt(
                                bufferedReader.readLine()
                        );
                        System.out.println( rIndex );

                        if ( rIndex >= singlyLinkedList.size() )
                        {
                            System.out.println(
                                    "Position specified is out of range!"
                            );
                        }
                        else
                        {
                            System.out.println(
                                    "Item " +
                                            singlyLinkedList.get( rIndex ) +
                                            " removed from position " +
                                            rIndex + " in the list."
                            );
                            singlyLinkedList.remove( rIndex );
                        }
                    }
                    break;

                // Get item from list
                case "3":
                    if ( singlyLinkedList.size() == 0 )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "    Enter position to retrieve item from : "
                        );
                        int myIndex =
                                Integer.parseInt( bufferedReader.readLine() );
                        System.out.println( myIndex );
                        if ( myIndex >= singlyLinkedList.size() )
                        {
                            System.out.println(
                                    "Position specified is out of range!");
                        }
                        else
                        {
                            System.out.println(
                                    "Item " +
                                            singlyLinkedList.get( myIndex )  +
                                            " retrieved from position " +
                                            myIndex + " in the list." );
                        }
                    }
                    break;

                // Clear list
                case "4":
                    singlyLinkedList.removeAll();
                    break;

                // Print size and content of list
                case "5":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                    {
                        System.out.print(
                                "List of size " + singlyLinkedList.size() +
                                        " has the following items : "
                        );
                        System.out.println(
                                singlyLinkedList.toString() );
                    }
                    break;

                // Delete largest item in the list
                case "6":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println(
                                "List empty, nothing to delete!");
                    }
                    else
                    {
                        Object maxItem =
                                max( singlyLinkedList.head ).getItem();

                        if ( singlyLinkedList.head.getItem().equals( maxItem ) )
                        {
                            // delete the first node from the list
                            singlyLinkedList.head =
                                    singlyLinkedList.head.getNext();
                        }
                        else
                        {
                            Node<Object> curr = singlyLinkedList.head;
                            Node<Object> prev = null;
                            while ( curr != null &&
                                    !curr.getItem().equals( maxItem ) )
                            {
                                prev = curr;
                                curr = curr.getNext();
                            }
                            prev.setNext( curr.getNext() );
                        }
                    }
                    break;

                // Reverse list
                case "7":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println(
                                "List is empty.. nothing to reverse!");
                    }
                    else
                    {
                        Node<Object> curr = singlyLinkedList.head;
                        Node<Object> next = null;
                        Node<Object> prev = null;

                        while ( curr != null )
                        {
                            next = curr.getNext();
                            curr.setNext( prev );
                            prev = curr;
                            curr = next;
                        }
                        singlyLinkedList.head = prev;

                        System.out.println("List has been reversed.");
                        System.out.print("Here is the content: ");
                        System.out.print(singlyLinkedList.toString() );
                        System.out.println();
                    }
                    break;

                // Exit program
                case "8":
                    System.out.print("Exiting program...Good Bye");
                    System.exit(0);
                    break;

                // -----------------------------------------------------
                // Investigate the value that the String class compareTo
                // method returns.
                // -----------------------------------------------------
                case "9":
                    System.out.println( "Enter two strings to compare." );

                    // enter first string
                    System.out.print("Insert first string: ");
                    String current = bufferedReader.readLine();
                    System.out.println( "   You entered: " + current );

                    // enter second string
                    System.out.println("Insert second string: ");
                    String next    = bufferedReader.readLine();
                    System.out.println( "   You entered: " + next );

                    // print 2 strings
                    System.out.println(
                            "       Compare " + current + " and " + next );

                    // make comparison
                    if ( current.compareTo( next ) > 0 )
                    {
                        System.out.println(
                                "       Larger string is " + current );
                    }
                    else if ( current.compareTo( next ) == 0 )
                    {
                        System.out.println(
                                "       They are equal strings." );
                    }
                    else
                    {
                        System.out.println(
                                "       Larger string is " + next );
                    }
                    break;

                // Find the largest item in list
                case "10":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println( "List is empty." );
                    }
                    else
                    {
                        System.out.print(
                                max( singlyLinkedList.head ).getItem() );
                        System.out.println(" is the largest item in list.");
                    }
                    break;

                default:
                    System.out.println("Not valid. Please enter again.");
                    break;

            } // end switch

        } // end while

    } // end main

} // end class MyListReferenceBasedDriver
