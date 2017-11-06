import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted:  10/17/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.09
 */
public class DriverTwo
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String[] args ) throws IOException
    {
        Deq<Object> doubleEndedQueue = new Deq<Object>();

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Insert item at back of Deq.");
            System.out.println("    2. Insert item at front of Deq.");
            System.out.println("    3. Remove item from front of Deq.");
            System.out.println("    4. Remove item from back of Deq.");
            System.out.println("    5. Display front item of Deq.");
            System.out.println("    6. Display last item of Deq.");
            System.out.println("    7. Clear Deq.");
            System.out.println("    8. Display content of Deq.");
            System.out.println("    9. Exit.");
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // Insert item at back of Deq.
                case "1":
                    System.out.println("You are now inserting an item at " +
                            "the back of the Deq.");
                    System.out.print("    Enter Item: ");
                    String back = bufferedReader.readLine().trim();
                    System.out.println( back );
                    doubleEndedQueue.enqueue( back );
                    System.out.println(
                            "Item " + back +
                                    " inserted at the back of the Deq.");
                    break;

                // Insert item at front of Deq.
                case "2":
                    System.out.println("You are now inserting an item at " +
                            "the front of the Deq.");
                    System.out.print("    Enter Item: ");
                    String front = bufferedReader.readLine().trim();
                    System.out.println( front );
                    doubleEndedQueue.enqueueFirst( front );
                    System.out.println("Item " + front +
                            " inserted at the front of the Deq.");
                    break;

                // Remove item from front of Deq.
                case "3":
                    if ( doubleEndedQueue.isEmpty() )
                    {
                        System.out.println("The Deq is empty.");
                    }
                    else
                    {
                        System.out.println("Item " +
                                doubleEndedQueue.peek() +
                                " removed from front of the Deq.");
                        doubleEndedQueue.dequeue();
                    }
                    break;

                // Remove item from back of Deq.
                case "4":
                    if ( doubleEndedQueue.isEmpty() )
                    {
                        System.out.println("The Deq is empty.");
                    }
                    else
                    {
                        System.out.println("Item " +
                                doubleEndedQueue.peekLast() +
                                " removed from back of the Deq.");
                        doubleEndedQueue.dequeueLast();
                    }
                    break;

                // Display front item of Deq.
                case "5":
                    if ( doubleEndedQueue.isEmpty() )
                    {
                        System.out.println("The Deq is empty.");
                    }
                    else
                    {
                        System.out.println("The first item in the Deq is " +
                                doubleEndedQueue.peek() );
                    }
                    break;

                // Display last item of Deq.
                case "6":
                    if ( doubleEndedQueue.isEmpty() )
                    {
                        System.out.println("The Deq is empty.");
                    }
                    else
                    {
                        System.out.println("The last item in the Deq is " +
                                doubleEndedQueue.peekLast() );
                    }
                    break;

                // Clear Deq.
                case "7":
                    if ( doubleEndedQueue.isEmpty() )
                    {
                        System.out.println("The Deq is empty.");
                    }
                    else
                    {
                        doubleEndedQueue.dequeueAll();
                    }
                    break;

                // Display content of Deq.
                case "8":
                    if ( doubleEndedQueue.isEmpty() )
                    {
                        System.out.println("The Deq is empty.");
                    }
                    else
                    {
                        System.out.println(
                                "The content of " +
                                        "the double ended queue contains: " +
                                doubleEndedQueue.toString()
                        );
                    }
                    break;

                // exit program
                case "9":
                    System.out.println("Exiting...\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n");
                    break;

            } // end switch

        } // end while

    } // end main

} // end class DriverTwo
