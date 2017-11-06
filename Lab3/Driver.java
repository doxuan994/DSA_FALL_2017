import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 3 Problem 2 + 3
 * Status: Complete and thoroughly tested
 * Last update: 10/04/17
 * Submitted:  10/10/17
 * Comment: Redone.
 * This is the Driver class for MyListReferenceBased (Problem 2).
 *
 * This Driver class has been updated with a better version for
 * purpose of improving the performance of the program.
 *
 * Also there is a small part that is related to problem 3.
 * Some methods have been revised or deleted for efficiency.
 *
 * @author: Xuan Do
 * @version: 2017.09.20
 */
public class Driver
{
    private static BufferedReader bufferedReader =
            new BufferedReader(
                    new InputStreamReader ( System.in ) );


     // This method is a part of problem 2 but it is used
     // compareTo which is a part of problem 3.
    private static Node max( Node head )
    {
        if ( head == null ) return null;
        if ( head.getNext() == null ) return head;
        Node max = head;

        for ( Node temp = head;
              temp.getNext() != null;
              temp = temp.getNext() )
        {
            String current = ( String ) temp.getItem();
            String next = ( String ) temp.getNext().getItem();
            // -----------------------------------------------------
            // Investigate the value that the String class compareTo
            // method returns.
            // -----------------------------------------------------
            if ( current.compareTo( next ) < 0 )
            {
                max = temp.getNext();
            }
        }
        return max;
    }

    public static void main ( String[] args ) throws IOException
    {
        MyListReferenceBased singlyLinkedList =
                                    new MyListReferenceBased();

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

            int numItems = singlyLinkedList.size();

            switch ( response )
            {
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
                    if ( index > numItems )
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

                // remove item from list
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

                        if ( rIndex >= numItems )
                        {
                            System.out.println(
                                    "Position specified is out of range!"
                            );
                        }
                        else
                        {
                            System.out.println(
                                "Item " +
                                        singlyLinkedList.get ( rIndex ) +
                                        " removed from position " +
                                        rIndex + " in the list."
                            );
                            singlyLinkedList.remove( rIndex );
                        }
                    }
                    break;

                // get item from list
                case "3":
                    int myIndex;
                    System.out.print(
                        "    Enter position to retrieve item from : "
                    );
                    myIndex = Integer.parseInt(
                            bufferedReader.readLine()
                    );
                    System.out.println( myIndex );

                    if ( myIndex >= numItems )
                    {
                        System.out.println(
                            "Position specified is out of range!");
                    }
                    else
                    {
                        System.out.println(
                            "Item " +
                                singlyLinkedList.get( myIndex ) +
                                " retrieved from position " +
                                myIndex + " in the list."
                        );
                    }
                    break;

                // clear list
                case "4":
                    singlyLinkedList.removeAll();
                    break;

                // print size and content of list
                case "5":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println("List is empty.");
                    }
                    else
                        {
                        System.out.print(
                                "List of size " + numItems +
                                        " has the following items : "
                        );
                        System.out.println( singlyLinkedList.toString() );
                    }
                    break;

                // delete largest item in the list
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
                            Node curr = singlyLinkedList.head;
                            Node prev = null;
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

                // reverse list
                case "7":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println(
                            "List is empty.. nothing to reverse!");
                    }
                    else
                    {
                        Node curr = singlyLinkedList.head;
                        Node next = null;
                        Node prev = null;

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
                        System.out.print( singlyLinkedList.toString() );
                        System.out.println();
                    }
                    break;

                // exit program
                case "8":
                    System.out.print("Exiting program...Good Bye");
                    System.exit(0);
                    break;

                // investigate the value that the String class
                // compareTo method
                case "9":
                    System.out.print( "Enter two string to compare: " );
                    String current = bufferedReader.readLine();
                    System.out.println( "You entered " + current );
                    String next    = bufferedReader.readLine();
                    System.out.println( "You entered " + next );

                    System.out.println( "Compare " + current +
                                        " and " + next );

                    if ( current.compareTo( next ) > 0 )
                    {
                        System.out.println( "Larger string is " + current );
                    }
                    else if ( current.compareTo( next ) == 0 )
                    {
                        System.out.println( "They are equal strings" );
                    }
                    else
                    {
                        System.out.println( "Larger string is " + next );
                    }
                    break;

                // find the largest item in list
                case "10":
                    if ( singlyLinkedList.isEmpty() )
                    {
                        System.out.println( "List is empty." );
                    }
                    else
                    {
                        System.out.print(
                            max( singlyLinkedList.head ).getItem()
                        );
                        System.out.println(" is the largest item in list.");
                    }
                    break;

                default:
                    System.out.println("Not valid. Please enter again.");
                    break;
            }
        }
    }
}