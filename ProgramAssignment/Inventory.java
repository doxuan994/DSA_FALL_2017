import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
/*
 * Purpose: Data Structure and Algorithms ( Programming Assignment 1 )
 * Status: Complete and thoroughly tested
 * Last update: 10/17/17
 * Submitted:  09/13/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.09.05
 */
public class Inventory
{
    private static ArrayList<Item> itemArray = new ArrayList<>();
    private static BufferedReader bufferedReader =
            new BufferedReader( new InputStreamReader( System.in ) );

    private static class Item
    {

        private String name = "";
        private int amount = 0;
        private double price = 0;
        private int location = 0;

        private Item( String newName,
                    int newAmount,
                    double newPrice,
                    int newLocation )
        {
            this.name = newName;
            this.amount = newAmount;
            this.price = newPrice;
            this.location = newLocation;
        }

        private String getName() {
            return name;
        }

        private int getAmount() {
            return amount;
        }

        private void setAmount( int newAmount ) {
            amount = newAmount;
        }

        private double getPrice() {
            return price;
        }

        private int getLocation() {
            return location;
        }

        private double getTotalPrices() {
            return amount * price;
        }

    } // end class Item

    // check if item is already added in the collection by
    // comparing the name of the item
    private static boolean alreadyAdded( String addedName )
    {
        for ( Item anItemArray : itemArray )
        {
            if ( anItemArray.getName().equalsIgnoreCase( addedName) )
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException
    {
        while ( true )
        {
            System.out.println(
                    "Welcome to the Inventory management program!\n");
            System.out.println("Select from the following options:");
            System.out.println("    0. Exit the program.");
            System.out.println("    1. Add an item.");
            System.out.println("    2. Delete an item.");
            System.out.println("    3. Display info about an item.");
            System.out.println("    4. Update an item.");
            System.out.println("    5. Display content of Inventory.");
            System.out.println("    6. Display info about items by shelf.");
            System.out.println(
                "    7. Display info about the most/least expensive item.");
            System.out.print("Make your menu selection now: ");
            String response = bufferedReader.readLine().trim();
            System.out.println( response );

            switch ( response )
            {
                // Exit program
                case "0":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                // Add an item
                case "1":

                    System.out.println("You are now adding a new item " +
                            "to the inventory.");
                    System.out.print("    Enter the name of the item: ");
                    String name = bufferedReader.readLine();
                    System.out.println(name);

                    if ( itemArray.isEmpty() )
                    {

                        System.out.print("    Enter the number of " +
                                "items of this type: ");
                        int amount =
                                Integer.parseInt(
                                        bufferedReader.readLine() );
                        System.out.println(amount);

                        System.out.print("    Enter the price of " +
                                "an item of this type: ");
                        double price =
                                Double.parseDouble(
                                        bufferedReader.readLine() );
                        System.out.println( price );

                        System.out.print("    Enter the location of " +
                                "this item (shelf number): ");
                        int location =
                                Integer.parseInt(
                                        bufferedReader.readLine() );
                        System.out.println( location );

                        Item item =
                                new Item( name, amount, price, location );
                        itemArray.add( item );

                        System.out.println("Information about the item " + '"'
                                + name + '"' + " has been registered!");

                    }
                    else
                    {
                        if ( alreadyAdded( name ) )
                        {

                            System.out.println(
                                    "    This item already exists in the inventory. " +
                                            "Please specify another item name!");
                            System.out.print("    Enter the name of the item: ");
                            name = bufferedReader.readLine();
                            System.out.println(name);

                            System.out.print("    Enter the number of " +
                                    "items of this type: ");
                            int amount =
                                    Integer.parseInt(
                                            bufferedReader.readLine() );
                            System.out.println(amount);

                            System.out.print("    Enter the price of " +
                                    "an item of this type: ");
                            double price =
                                    Double.parseDouble(
                                            bufferedReader.readLine() );
                            System.out.println(price);

                            System.out.print("    Enter the location of " +
                                    "this item (shelf number): ");
                            int location =
                                    Integer.parseInt(
                                            bufferedReader.readLine() );
                            System.out.println( location );

                            Item item =
                                    new Item( name, amount, price, location );
                            itemArray.add( item );

                            System.out.println("Information about the item " +
                                    '"' + name + '"' + " has been registered!");
                            break;
                        }
                        else
                        {

                            System.out.print("    Enter the number of "+
                                    "items of this type: ");
                            int amount =
                                    Integer.parseInt(
                                            bufferedReader.readLine() );
                            System.out.println(amount);

                            System.out.print("    Enter the price of "+
                                    "an item of this type: ");
                            double price =
                                    Double.parseDouble(
                                            bufferedReader.readLine() );
                            System.out.println(price);

                            System.out.print("    Enter the location of "+
                                    "this item (shelf number): ");
                            int location =
                                    Integer.parseInt(
                                            bufferedReader.readLine() );
                            System.out.println(location);

                            Item item =
                                    new Item( name, amount, price, location );
                            itemArray.add( item );

                            System.out.println("Information about the item " +
                                    '"' + name + '"' + " has been registered!");
                            break;
                        }

                    } // end if-else
                    break;

                // Delete an item
                case "2":

                    if ( itemArray.isEmpty() )
                    {
                        System.out.println(
                                "    Error: No items in the inventory"
                        );
                        break;
                    }
                    else
                    {
                        System.out.print(
                                "Enter name of the item you want to " +
                                "delete form the inventory: ");
                        String removedName = bufferedReader.readLine();
                        System.out.println( removedName );

                        for (int i = 0; i < itemArray.size(); i++)
                        {
                            if ( itemArray.
                                    get(i).
                                    getName().
                                    equalsIgnoreCase( removedName) )
                            {

                                System.out.println(
                                        "Info for " +
                                        removedName +
                                        " has been deleted"
                                );
                                itemArray.remove(i);

                            }
                        }
                        break;
                    }

                // Display information
                case "3":

                    if ( itemArray.isEmpty() )
                    {
                        System.out.println(
                                "    Error: No items in the inventory" );
                        break;
                    }
                    else
                    {
                        System.out.print(
                                "Enter name of item in the inventory to " +
                                "search for: "
                        );
                        String infoItem = bufferedReader.readLine();
                        System.out.println(infoItem);

                        if ( !alreadyAdded( infoItem ) )
                        {
                            System.out.println(
                                    "    No such item in the inventory."
                            );
                            break;
                        }
                        else
                        {
                            for ( Item anItemArray : itemArray )
                            {
                                if ( anItemArray
                                        .getName()
                                        .equalsIgnoreCase( infoItem ) )
                                {

                                    System.out.println(
                                            "    Item information for " +
                                            anItemArray.getName()
                                    );
                                    System.out.println(
                                            "        Amount : " +
                                            anItemArray.getAmount()
                                    );
                                    System.out.println(
                                            "        Price : " +
                                            anItemArray.getPrice()
                                    );
                                    System.out.println(
                                    "        Location (shelf number) : " +
                                            anItemArray.getLocation()
                                    );

                                }

                            }
                            break;
                        }

                    } // end if-else

                // Update an item
                case "4":

                    if ( itemArray.isEmpty() )
                    {
                        System.out.println("    Error: No items in the inventory");
                        break;
                    }
                    else
                    {

                        System.out.print("Enter name of item in the inventory " +
                                "for which to update the amount: ");
                        String itemName = bufferedReader.readLine();
                        System.out.println( itemName );

                        if ( !alreadyAdded( itemName) )
                        {
                            System.out.println("    No such item in the inventory.");
                            break;
                        }
                        else
                        {
                            for (int i = 0; i < itemArray.size(); i++)
                            {
                                if (itemArray
                                        .get(i)
                                        .getName()
                                        .equalsIgnoreCase(itemName)) {

                                    System.out.print("\nEnter the new amount: ");
                                    int newAmount =
                                            Integer.parseInt( bufferedReader.readLine() );
                                    System.out.println(newAmount);

                                    if ( newAmount == 0 )
                                    {

                                        System.out.println("Info for " +
                                                itemName +
                                                " has been deleted");
                                        itemArray.remove(i);

                                        break;

                                    }
                                    else
                                    {
                                        if (itemArray.get(i)
                                                .getName()
                                                .equalsIgnoreCase( itemName) )
                                        {

                                            itemArray.get(i).
                                                    setAmount(newAmount);

                                            System.out.println(
                                                "    New item information for " +
                                                        itemArray.
                                                            get(i).
                                                            getName() );
                                            System.out.println(
                                                "        Amount : " +
                                                    itemArray.
                                                            get(i).
                                                            getAmount() );
                                            System.out.println(
                                                "        Price : " +
                                                    itemArray.
                                                            get(i).
                                                            getPrice() );
                                            System.out.println(
                                                "        Location (shelf number) : " +
                                                    itemArray.
                                                            get(i).
                                                            getLocation() );
                                            break;
                                        }

                                    } // end if-else

                                } // end if

                            } // end for

                        } // end if-else

                    } // end if-else

                    break;

                // Display content of Inventory
                case "5":
                    int totalItems = 0;
                    double totalPrice = 0;

                    if ( itemArray.isEmpty() )
                    {
                        System.out.println("The inventory has no items.");
                        break;
                    }
                    else
                    {
                        System.out.println(
                                "The inventory has information about the following "
                                        + itemArray.size() + " items");

                        for (Item anItemArray : itemArray)
                        {
                            System.out.println(
                                    "    Item information for " +
                                            anItemArray.getName() );
                            System.out.println(
                                    "        Amount : " +
                                            anItemArray.getAmount() );
                            System.out.println(
                                    "        Price : " +
                                            anItemArray.getPrice() );
                            System.out.println(
                                    "        Location (shelf number) : " +
                                            anItemArray.getLocation() );

                            totalItems += anItemArray.getAmount();
                            totalPrice += anItemArray.getTotalPrices();
                        }
                        System.out.println(
                                "The inventory has a total of " +
                                        totalItems +
                                        " items with a cumulative price of $" +
                                        totalPrice);
                    }
                    break;

                // Display info about items by shelf
                case "6":
                    int current = 0;
                    double totalSectionCost = 0;
                    int totalAmount = 0;
                    int counter = 0;

                    if ( itemArray.isEmpty() )
                    {
                        System.out.println("The inventory has no items.");
                        break;
                    }
                    else
                    {
                        System.out.println(
                            "The inventory has information about the following " +
                                itemArray.size() + " items");
                        itemArray.sort(
                                Comparator.comparing ( Item::getLocation ) );


                        for (int i = 0; i < itemArray.size(); i++) {

                            if ( i == (itemArray.size() - 1) ) {
                                // conditional for indexOutOfRange exception

                                // print last item of the collection here
                                System.out.println(
                                        "    Item information for " +
                                                itemArray.get(i).getName());
                                System.out.println(
                                        "        Amount : " +
                                                itemArray.get(i).getAmount());
                                System.out.println(
                                        "        Price : " +
                                                itemArray.get(i).getPrice());
                                System.out.println(
                                        "        Location (shelf number) : " +

                                                itemArray.get(i).getLocation());

                                System.out.println(
                                        "The inventory has a total of " +
                                                (itemArray.get(i).getAmount() +
                                                        totalAmount) +
                                                " items with a cumulative price of $" +
                                                (itemArray.get(i).getTotalPrices() +
                                                        totalSectionCost) +
                                                " on shelf " + current);

                                break;

                            } else {
                                current = itemArray.get(i).getLocation();

                                // print info for the first item of new location
                                if ( counter == 0 ) {
                                    System.out.println(
                                            "    Item information for " +
                                                    itemArray.get(i).getName());
                                    System.out.println(
                                            "        Amount : " +
                                                    itemArray.get(i).getAmount());
                                    System.out.println(
                                            "        Price : " +
                                                    itemArray.get(i).getPrice());
                                    System.out.println(
                                            "        Location (shelf number) : " +
                                                    itemArray.get(i).getLocation());

                                    totalSectionCost += itemArray.get(i).getTotalPrices();
                                    totalAmount += itemArray.get(i).getAmount();
                                    counter++;
                                }

                                // print info for the second item and so on but not to
                                // print info for the last item of collection here

                                if ( ( itemArray.get( i + 1 )
                                        .getLocation() == current ) &&
                                        ( i < ( itemArray.size() - 1 ) ) ) {

                                    System.out.println(
                                            "    Item information for " +
                                                    itemArray.get(i + 1).getName());
                                    System.out.println(
                                            "        Amount : " +
                                                    itemArray.get(i + 1).getAmount());
                                    System.out.println(
                                            "        Price : " +
                                                    itemArray.get(i + 1).getPrice());
                                    System.out.println(
                                            "        Location (shelf number) : " +
                                                    itemArray.get(i + 1).getLocation());

                                    totalSectionCost += itemArray.get(i + 1).getTotalPrices();
                                    totalAmount += itemArray.get(i + 1).getAmount();
                                    counter++;

                                } else { // end of location section
                                    System.out.println(
                                            "The inventory has a total of " +
                                                    totalAmount +
                                                    " items with a cumulative price of $" +
                                                    totalSectionCost +
                                                    " on shelf " +
                                                    current);

                                    current = itemArray.get(i + 1).getLocation();
                                    totalSectionCost = 0;
                                    totalAmount = 0;
                                    counter = 0;
                                }

                            } // end if-else

                        } // end for

                    } // end if-else
                    break;

                // Display info about the most/least expensive item
                case "7":
                    if ( itemArray.isEmpty() )
                    {
                        System.out.println("The inventory has no items.");
                        break;
                    }
                    else
                    {
                        itemArray.sort( Comparator.comparing(Item::getPrice) );

                        for (int i = itemArray.size() - 1; i >= 0; i--)
                        {
                            if (i == ( itemArray.size() - 1) )
                            {

                                System.out.println("    The most expensive item " +
                                        "in the inventory is "
                                                + itemArray.get(i).getName() );
                                System.out.println("        Amount : " +
                                                itemArray.get(i).getAmount() );
                                System.out.println("        Price : " +
                                                itemArray.get(i).getPrice() );
                                System.out.println("Location (shelf number) : " +
                                                itemArray.get(i).getLocation() );

                            }
                            else if ( i == 0 )
                            {
                                System.out.println(
                                        "    The least expensive item " +
                                                "in the inventory is "
                                                + itemArray.get(i).getName() );
                                System.out.println(
                                        "        Amount : " +
                                                itemArray.get(i).getAmount() );
                                System.out.println(
                                        "        Price : " +
                                                itemArray.get(i).getPrice() );
                                System.out.println(
                                        "        Location (shelf number) : " +
                                                itemArray.get(i).getLocation() );
                            }

                        }

                    }
                    break;

                default:
                    System.out.println(
                            "Not valid. Please enter again.\n");
                    break;

            } // end switch

        } // end while

    } // end main

} // end Inventory class
