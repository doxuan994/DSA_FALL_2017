import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 1
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted:  10/17/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.09
 */
public class Driver
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String[] args ) throws IOException
    {
        Queue<Object> myQueue = new Queue<Object>();

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Insert item at back of queue.");
            System.out.println("    2. Remove item from front of queue.");
            System.out.println("    3. Display front item of queue.");
            System.out.println("    4. Clear queue.");
            System.out.println("    5. Display content of queue.");
            System.out.println("    6. Exit.");
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // insert item at back of queue
                case "1":
                    System.out.println(
                            "You are now inserting an item at " +
                            "the back of the queue.");
                    System.out.print("    Enter Item: ");
                    String item = bufferedReader.readLine().trim();
                    System.out.println( item );

                    myQueue.enqueue( item );
                    break;

                // remove item from front of queue
                case "2":
                    if ( myQueue.isEmpty() )
                    {
                        System.out.println("Queue is empty.");
                    }
                    else
                    {
                        System.out.println("Item " +
                                myQueue.peek() +
                                " removed from front of the Queue.");
                        myQueue.dequeue();
                    }
                    break;

                // display front item of queue
                case "3":
                    if ( myQueue.isEmpty() )
                    {
                        System.out.println("Queue is empty.");
                    }
                    else
                    {
                        System.out.println(
                                "The front item of the queue is " +
                                myQueue.peek() );
                    }
                    break;

                // clear queue
                case "4":
                    if ( myQueue.isEmpty() )
                    {
                        System.out.println("Queue is empty.");
                    }
                    else
                    {
                        myQueue.dequeueAll();
                    }
                    break;

                // display content of queue
                case "5":
                    if ( myQueue.isEmpty() )
                    {
                        System.out.println("Queue is empty.");
                    }
                    else
                    {
                        System.out.println(
                                "The content of the queue contains: " +
                                        myQueue.toString() );
                    }
                    break;

                // exit program
                case "6":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n");
                    break;

            } // end switch

        } // end while

    } // end main

} // end class Driver
