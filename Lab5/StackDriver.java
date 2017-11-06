import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted:  10/10/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.04
 */
public class StackDriver
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main ( String[] args ) throws IOException
    {
        Stack<Object> myStack = new Stack<Object>();

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Push item onto stack.");
            System.out.println("	2. Pop item from stack.");
            System.out.println("	3. Display top item from stack.");
            System.out.println("    4. Display items in stack.");
            System.out.println("	5. Clear stack.");
            System.out.println("	6. Exit.");
            System.out.print( "Make your menu selection now: " );
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // push item onto stack
                case "1":
                    System.out.println(
                            "You are now inserting an item to " +
                            "the top of the stack.");
                    System.out.print("    Enter Item: ");
                    String newItem = bufferedReader.readLine().trim();
                    System.out.println( newItem );

                    myStack.push( newItem );
                    break;

                // remove the top of a stack
                case "2":
                    if ( myStack.isEmpty() )
                    {
                        System.out.println("Stack is empty.");
                    }
                    else
                    {
                        System.out.println("Item " + myStack.peek() +
                            " was removed from the Stack.");
                        myStack.pop();

                    }
                    break;

                // display top item from stack
                case "3":
                    if ( myStack.isEmpty() )
                    {
                        System.out.println("Stack is empty.");
                    }
                    else
                    {
                        System.out.println(
                                "The top item of the stack is " +
                                myStack.peek() );
                    }
                    break;

                // display items in stack
                case "4":
                    if ( myStack.isEmpty() )
                    {
                        System.out.println("Stack is empty.");
                    }
                    else
                    {
                        System.out.println(
                                "The content of the stack contains: " +
                                        myStack.toString() );
                    }
                    break;

                // clear stack
                case "5":
                    if ( myStack.isEmpty() )
                    {
                        System.out.println("Stack is empty.");
                    }
                    else
                    {
                        myStack.popAll();
                    }
                    break;

                // exit program
                case "6":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.");
                    break;
            } // end switch

        } // end while

    } // end main

} // end class StackDriver