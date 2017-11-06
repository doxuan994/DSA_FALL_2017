import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Purpose: Data Structure and Algorithms MidTerm
 * Status: Complete and thoroughly tested
 * Last update: 10/18/17
 * Submitted:  10/18/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.18
 */
public class Driver
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String[] args ) throws IOException
    {
        // Combination between Queue and ListCDLSBased
        Queue<Buy> buyStock = new Queue<Buy>();
        Queue<Sell> sellStock = new Queue<Sell>();
        Queue<Pending> pendingStock = new Queue<Pending>();

        int numServed = 0;
        int numSellAdded = 0;

        System.out.println("Welcome to the Card Trading Center!");

        System.out.print("Enter number of basketball in the stock: ");
        int baskStock = Integer.parseInt( bufferedReader.readLine().trim() );
        System.out.println( baskStock );

        System.out.print("Enter number of baseball in the stock: ");
        int baseStock = Integer.parseInt( bufferedReader.readLine().trim() );
        System.out.println( baseStock );

        System.out.print("Enter number of football in the stock: ");
        int footStock = Integer.parseInt( bufferedReader.readLine().trim() );
        System.out.println( footStock );

        Sell myStock = new Sell( baskStock, baseStock, footStock );
        sellStock.enqueue( myStock );



        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println("    0. Display stock and exit.");
            System.out.println("    1. Customer enters with request to buy cards.");
            System.out.println("    2. Customer enters with cards to sell cards.");
            System.out.println("    3. Customer with request to buy is served.");
            System.out.println("    4. Display customers waiting to be served and their requests.");
            System.out.println("    5. Display pending requests waiting to be processed.");
            System.out.println("    6. Process pending requests.");
            System.out.println("    7. Display number of customers whose requests have been processed.");

            System.out.print("\nYou know the choices; make your selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                case "0":
                    System.exit(0);
                    break;

                // Customer enters with request to buy cards
                case "1":
                    // enter name
                    System.out.print("Welcome, your name, please: ");
                    String buyName = bufferedReader.readLine().trim();
                    System.out.println( buyName );

                    // enter basketball
                    System.out.print("How many basketball cards do you want: ");
                    int baskBuy = Integer.parseInt( bufferedReader.readLine().trim() );
                    System.out.println( baskBuy );

                    // enter baseball
                    System.out.print("How many baseball cards do you want: ");
                    int baseBuy = Integer.parseInt( bufferedReader.readLine().trim() );
                    System.out.println( baseBuy );

                    // enter football
                    System.out.print("How many football cards do you want: ");
                    int footBuy = Integer.parseInt( bufferedReader.readLine().trim() );
                    System.out.println( footBuy );

                    Buy buyRequest = new Buy( buyName, baskBuy, baseBuy, footBuy );
                    buyStock.enqueue( buyRequest );

                    System.out.println( buyName + " requesting " + baskBuy + " basketball, " +
                    baseBuy + " baseball and " + footBuy + " football cards is now waiting.");

                    break;

                // Customer enters with cards to sell cards.
                case "2":
                    // enter name
                    System.out.print("Welcome, your name, please: ");
                    String sellName = bufferedReader.readLine().trim();
                    System.out.println( sellName );

                    // enter basketball
                    System.out.print("How many basketball cards do you want: ");
                    int baskSell = Integer.parseInt( bufferedReader.readLine().trim() );
                    System.out.println( baskSell );

                    // enter baseball
                    System.out.print("How many baseball cards do you want: ");
                    int baseSell = Integer.parseInt( bufferedReader.readLine().trim() );
                    System.out.println( baseSell );

                    // enter football
                    System.out.print("How many football cards do you want: ");
                    int footSell = Integer.parseInt( bufferedReader.readLine().trim() );
                    System.out.println( footSell );

                    Sell sellRequest = new Sell( sellName, baskSell, baseSell, footSell );
                    sellStock.enqueue( sellRequest );

                    System.out.println( "Thanks" +
                            sellName + ", here is your receipt for the " +
                            baskSell + " basketball, " +
                            baseSell + " baseball and " +
                            footSell + " football cards!");
                    numSellAdded++;

                    break;

                // Customer with request to buy is served.
                case "3":
                    if ( buyStock.isEmpty() )
                    {
                        System.out.println("No customer is waiting to be served!");
                    }
                    else
                    {
                        if ( sellStock.isEmpty() )
                        {
                            Pending newPending = new Pending(
                                    buyStock.peek().getName(),
                                    buyStock.peek().getBasketball(),
                                    buyStock.peek().getBaseball(),
                                    buyStock.peek().getFootball()
                            );

                            pendingStock.enqueue( newPending );
                            buyStock.dequeue();
                        }
                        else
                        {
                            if (    sellStock.peek().getBaseball()   >= buyStock.peek().getBaseball() &&
                                    sellStock.peek().getBasketball() >= buyStock.peek().getBasketball() &&
                                    sellStock.peek().getFootball()   >= buyStock.peek().getFootball() )
                            {
                                System.out.println(
                                        buyStock.peek().getName() + " is leaving with " +
                                                buyStock.peek().getBasketball() + ", " +
                                                buyStock.peek().getBaseball() + " baseball and " +
                                                buyStock.peek().getFootball() + " football cards."
                                );

                                sellStock.dequeue();
                                buyStock.dequeue();
                                numServed++;

                            }
                            else
                            {
                                Pending newPending = new Pending(
                                        buyStock.peek().getName(),
                                        buyStock.peek().getBasketball(),
                                        buyStock.peek().getBaseball(),
                                        buyStock.peek().getFootball()
                                );
                                pendingStock.enqueue( newPending );
                                buyStock.dequeue();
                            }
                        }
                    }
                    break;

                // Display customers waiting to be served and their requests.
                case "4":
                    if ( buyStock.isEmpty() )
                    {
                        System.out.println("No customer is waiting to be served!");
                    }
                    else
                    {
                        System.out.println("The following customers are waiting to be served:");
                        System.out.println(
                                buyStock.peek().getName() + " requesting " +
                                        buyStock.peek().getBasketball() + " basketball, " +
                                        buyStock.peek().getBaseball() + " baseball and " +
                                        buyStock.peek().getFootball() + " football cards."
                        );
                    }

                    break;

                // Display pending requests waiting to be processed.
                case "5":
                    if ( pendingStock.isEmpty() )
                    {
                        System.out.println("No customer requests are pending!");
                    }
                    else
                    {
                        System.out.println("The following requests are pending:");
                        System.out.println(
                                pendingStock.peek().getName() + " requesting " +
                                        pendingStock.peek().getBasketball() + " basketball, " +
                                        pendingStock.peek().getBaseball() + " baseball and " +
                                        pendingStock.peek().getFootball() + " football cards."
                        );
                    }
                    break;

                // Process pending requests.
                case "6":
                    if ( pendingStock.isEmpty() )
                    {
                        System.out.println("No request could be processed!");
                    }
                    else
                    {

                        if (    !sellStock.isEmpty() &&
                                sellStock.peek().getBaseball()   >= pendingStock.peek().getBaseball() &&
                                sellStock.peek().getBasketball() >= pendingStock.peek().getBasketball() &&
                                sellStock.peek().getFootball()   >= pendingStock.peek().getFootball() )
                        {
                            System.out.println(
                                    sellStock.peek().getName() + " is leaving with " +
                                            sellStock.peek().getBasketball() + ", " +
                                            sellStock.peek().getBaseball() + " baseball and " +
                                            sellStock.peek().getFootball() + " football cards."
                            );
                            sellStock.dequeue();
                            pendingStock.dequeue();
                        }
                    }
                    break;

                // Display number of customers whose requests have been processed.
                case "7":
                    if ( numServed == 0 )
                    {
                        System.out.println("No customers have been served yet!");
                    }
                    else
                    {
                        System.out.println( numServed + numSellAdded + " customers have been served." );
                    }
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n");
                    break;

            } // end switch

        } // end while

    } // end main

} // end class Driver
