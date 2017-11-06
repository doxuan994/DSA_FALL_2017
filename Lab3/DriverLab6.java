import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms Lab 6 Problem 3
 * Status: Incomplete
 * Last update: 10/09/17
 * Submitted:  10/17/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.09
 */
public class DriverLab6
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String[] args ) throws IOException
    {
        ListReferenceBased left  = new ListReferenceBased();

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    1. Experience Problem 3.");
            System.out.println("    2. Exit.");

            System.out.print("Make your menu selection now: ");
            String res = bufferedReader.readLine().trim();
            System.out.println( res );

            switch( res )
            {
                case "1":
                    int leftCounter  = 0;

                    System.out.print("Enter Item: ");
                    String response =
                            bufferedReader.readLine().trim();
                    System.out.println( response );


                    //--------------------------------------------
                    //           BEGIN INSERTING DATA
                    //--------------------------------------------

                    if ( response.equals("-") )
                        // if first left character is empty
                    {
                        System.out.print("Enter Item: ");
                        response = bufferedReader.readLine().trim();
                        System.out.println( response );

                        if ( response.equals(".") )
                        // and the first right character is also empty
                        {
                            System.out.println(
                                "Same Length and " +
                                    "Same Content, No Palindrome");
                            break;
                        }
                        else
                        {
                            System.out.println("Right Longer");
                            break;
                        }
                    } // END IF
                    else // left character is not empty
                    {
                        while ( !response.equals( "-" ) &&
                                !response.equals(".") )
                        // not see minus side,
                        // continue read in left character
                        {
                            left.add( leftCounter, response );
                            leftCounter++;
                            System.out.print("Enter Item: ");
                            response = bufferedReader.readLine().trim();
                            System.out.println( response );
                        }

                        if ( response.equals("-") )
                        {
                            //-----------------------------------
                            //             SEE MINUS
                            //-----------------------------------
                            System.out.print("Enter Item: ");
                            response = bufferedReader.readLine().trim();
                            // read in right character
                            System.out.println( response );

                            if ( response.equals(".") )
                            // end of sentence before reading
                            // any characters from the right,
                            // meaning that they are empty
                            {
                                System.out.println("Left Longer    ");
                            }
                            else
                            {
                                int num = leftCounter - 1;
                                //----------------------------------------
                                //    WHILE LOOP CHECK FOR PALINDROME
                                //----------------------------------------
                                while ( !response.equals("") &&
                                        !response.equals(".") )
                                // not end of sentence,
                                // right will never shorter here
                                {
                                    if ( num >= 0 && num < left.size() )
                                    {
                                        String leftItem =
                                                ( String ) left.get( num );

                                        if ( leftItem.compareTo( response ) != 0 )
                                            // matching character
                                        {
                                            System.out.print("Enter Item: ");
                                            response =
                                                bufferedReader.readLine().trim();
                                            System.out.println( response );
                                            num--;
                                        }
                                        else // no match
                                        {
                                            System.out.print("Enter Item: ");
                                            response =
                                                bufferedReader.readLine().trim();
                                            System.out.println( response );
                                            num--;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println(
                                            "    Right Longer");
                                        break;
                                    }

                                } // end WHILE

                                if ( num == -1 && response.equals(".") )
                                // condition when right is equal,
                                {
                                    System.out.println("Same Length");
                                    break;
                                }
                                else if ( num >= 0 && response.equals(".") )
                                // or shorter than left
                                {
                                    System.out.println("Left Longer    ");
                                    break;
                                }
                            }
                        }
                        else
                        {
                            System.out.println("No Minus");
                        } // no minus checking condition

                    } // END ELSE
                    break;

                case "2":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Not valid. Please enter again.\n");
                    break;
            }

        } // end while

    } // end main

} // end class DriverLab6
