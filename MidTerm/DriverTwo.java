import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DriverTwo
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main( String[] args ) throws IOException
    {
        ListArrayBased<Buy> buyStock = new ListArrayBased<Buy>();
        ListArrayBased<Sell> sellStock = new ListArrayBased<Sell>();
        ListArrayBased<Pending> pendingStock = new ListArrayBased<Pending>();

        int numServed = 0;
        int numSellAdded = 0;
        int addedIndex = 0;
        int pendingIndex = -1;

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
        sellStock.add( addedIndex, myStock );

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
                    buyStock.add( addedIndex, buyRequest );
                    addedIndex++;

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
                    sellStock.add( addedIndex+1, sellRequest );

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
                                    buyStock.get(0).getName(),
                                    buyStock.get(0).getBasketball(),
                                    buyStock.get(0).getBaseball(),
                                    buyStock.get(0).getFootball()
                            );
                            pendingStock.add( pendingIndex+1, newPending );
                            buyStock.remove(0);
                        }
                        else
                        {
                            if (    sellStock.get(0).getBaseball()   >= buyStock.get(0).getBaseball() &&
                                    sellStock.get(0).getBasketball() >= buyStock.get(0).getBasketball() &&
                                    sellStock.get(0).getFootball()   >= buyStock.get(0).getFootball() )
                            {
                                System.out.println(
                                        buyStock.get(0).getName() + " is leaving with " +
                                        buyStock.get(0).getBasketball() + ", " +
                                        buyStock.get(0).getBaseball() + " baseball and " +
                                        buyStock.get(0).getFootball() + " football cards."
                                );

                                sellStock.remove(0);

                                buyStock.remove(0);
                                numServed++;
                            }
                            else
                            {
                                Pending newPending = new Pending(
                                        buyStock.get(0).getName(),
                                        buyStock.get(0).getBasketball(),
                                        buyStock.get(0).getBaseball(),
                                        buyStock.get(0).getFootball()
                                );
                                pendingStock.add( pendingIndex+1, newPending );
                                buyStock.remove(0);
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
                        for ( int i = 0; i < ( addedIndex - 1 ); i++ )
                        {
                            System.out.println(
                                    buyStock.get(i).getName() + " requesting " +
                                    buyStock.get(i).getBasketball() + " basketball, " +
                                    buyStock.get(i).getBaseball() + " baseball and " +
                                    buyStock.get(i).getFootball() + " football cards."
                            );
                        }
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
                                pendingStock.get(0).getName() + " requesting " +
                                pendingStock.get(0).getBasketball() + " basketball, " +
                                pendingStock.get(0).getBaseball() + " baseball and " +
                                pendingStock.get(0).getFootball() + " football cards."
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
                                sellStock.get(0).getBaseball()   >= pendingStock.get(0).getBaseball() &&
                                sellStock.get(0).getBasketball() >= pendingStock.get(0).getBasketball() &&
                                sellStock.get(0).getFootball()   >= pendingStock.get(0).getFootball() )
                        {
                            System.out.println(
                                    sellStock.get(0).getName() + " is leaving with " +
                                            sellStock.get(0).getBasketball() + ", " +
                                            sellStock.get(0).getBaseball() + " baseball and " +
                                            sellStock.get(0).getFootball() + " football cards."
                            );
                            sellStock.remove(0);
                            pendingStock.remove(0);
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

} // end class DriverTwo
