import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/09/17
 * Submitted:  10/10/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.04
 */
public class StackDriverTwo
{
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    public static void main ( String[] args ) throws IOException
    {
        // store layers
        Stack<Layer> bag = new Stack<Layer>();
        // store sample weight
        Stack<Double> sampleBag = new Stack<Double>();

        int layers = 0;
        int sampleItems = 0;

        double bagWeight = 0.0;
        double sampleBagWeight = 0.0;

        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        while ( true )
        {
            System.out.println("\nSelect from the following menu: ");
            System.out.println(
                    "    1. Place a layer of item(s) in the bag.");
            System.out.println(
                    "    2. Remove a layer of item(s) from the bag.");
            System.out.println(
                    "	3. Display the weight of the bag.");
            System.out.println(
                    "	4. Display the number of layers in the bag.");
            System.out.println(
                    "	5. Display the number of items and " +
                            "the weight of the sample bag.");
            System.out.println(
                    "	6. Remove an item from the sample bag.");
            System.out.println(
                    "	7. Empty the sample bag." );
            System.out.println("    8. Exit" );
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // Place a layer of item(s) in the bag
                case "1":
                    System.out.print(
                        "Enter number of items to place in the bag : ");

                    // enter number of items
                    int numItems =
                            Integer.parseInt(
                                    bufferedReader.readLine().trim() );
                    System.out.println( numItems );

                    // enter weight
                    System.out.print("Enter weight of item (lb): ");
                    double weight =
                            Double.parseDouble(
                                    bufferedReader.readLine().trim() );
                    System.out.println( weight );

                    // create a new layer with the given information
                    Layer newLayer = new Layer( numItems, weight );
                    // add a layer to the top of a stack.
                    bag.push( newLayer );

                    // print a message
                    System.out.println( numItems +
                            " items weighing " +
                            decimalFormat.format( weight ) +
                            " lbs have been placed in the bag." );

                    // increase number of layers by 1
                    layers++;

                    // calculate total weight of top layer
                    double topLayerWeight =
                                    bag.peek().getItems() *
                                    bag.peek().getWeight();

                    // add total weight of current layer to the bag
                    bagWeight += topLayerWeight;
                    break;

                // Remove a layer of item(s) from the bag
                case "2":
                    if( bag.isEmpty() )
                    {
                        System.out.println("Error: Empty Bag.");
                    }
                    else
                    {
                        // subtract total weight of the top layer
                        // of the bag
                        bagWeight -=
                                bag.peek().getItems() *
                                        bag.peek().getWeight();

                        // print a message
                        System.out.println(
                                bag.peek().getItems() +
                                " item(s) have been removed from the bag."
                        );

                        // prompt users for a copy
                        System.out.print(
                                "Would you like to store a sample from " +
                                        "this layer(Y/N)?");
                        response = bufferedReader.readLine().trim();
                        System.out.println( response );

                        // store a sample weight to the sample bag
                        if ( response.equalsIgnoreCase( "Y" ) )
                        {
                            // calculate a sample weight of
                            // an item from the top
                            Double sampleWeightItem =
                                    bag.peek().getWeight();
                            // add the sample weight to the top of
                            // sample bag
                            sampleBag.push( sampleWeightItem );
                            System.out.println( "Sample Stored." );

                            // increase number of items in the sample
                            // bag by 1
                            sampleItems++;
                            // increase sample bag weight by the weight of
                            // current top item of the sample bag
                            sampleBagWeight += sampleBag.peek();
                        }

                        // remove the layer
                        bag.pop();

                        // decrease number of layers by 1
                        layers--;
                    }
                    break;

                // Display the weight of the bag
                case "3":
                    if ( bag.isEmpty() )
                    {
                        System.out.println(
                            "The bag is empty : Weight is 0 lbs.");
                    }
                    else
                    {
                        System.out.println(
                                "The weight of the bag is " +
                                decimalFormat.format( bagWeight ) +
                                " lbs.");
                    }
                    break;

                // Display the number of layers in the bag
                case "4":
                    if( bag.isEmpty() )
                    {
                        System.out.println(
                                "The bag is empty : No Layers.");
                    }
                    else
                    {
                        System.out.println(
                                "The number of layers in the bag is " +
                                        layers + ".");
                    }
                    break;

                // Display the number of items and
                // the weight of the sample bag
                case "5":
                    if ( sampleBag.isEmpty() )
                    {
                        System.out.println(
                                "The sample bag is empty : No Items.");
                    }
                    else
                    {
                        System.out.println(
                                "The number of items in " +
                                        "the sample bag is " +
                                        sampleItems );
                        System.out.println(
                                "The sample bag weights " +
                                        sampleBagWeight + " lbs.");
                    }
                    break;

                // Remove an item from the sample bag
                case "6":
                    if ( sampleBag.isEmpty() )
                    {
                        System.out.println("Error: Empty sample bag.");
                    }
                    else
                    {
                        System.out.println("An item weighing " +
                                decimalFormat.format( sampleBag.peek() ) +
                                " lbs has been removed from " +
                                "the sample bag.");
                        // decrease number of items in sample bag by 1
                        sampleItems--;
                        // subtract weight of the top of
                        // the sample bag
                        sampleBagWeight -= sampleBag.peek();
                        // remove an item from the sample bag
                        sampleBag.pop();
                    }
                    break;

                // Empty the sample bag
                case "7":
                    if ( sampleBag.isEmpty() )
                    {
                        System.out.println(
                                "Error: Empty sample bag." );
                    }
                    else
                    {
                        // empty sample bag items and
                        // sample bag total weight
                        sampleItems = 0;
                        sampleBagWeight = 0.0;
                        // empty sample bag
                        sampleBag.popAll();
                        System.out.println(
                                "The sample bag has been emptied.");
                    }
                    break;

                // Exit program
                case "8":
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

} // end class StackDriverTwo
