import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * Purpose: Data Structure and Algorithms Lab 1 Problem 9
 * Status: Complete and thoroughly tested
 * Last update: 09/25/17
 * Submitted:  09/26/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.09.06
 */
public class Characters {

    // Initializing BufferedReader
    static BufferedReader bufferedReader =
            new BufferedReader ( new InputStreamReader(System.in) );

    // addition of one new item (character) at the end of the collection
    public static void add
    ( ArrayList<Character> data, char newData )
    {
        data.add(newData);
    }

    // using for loop
    public static void displayNameOfProcessingMethod
    ( ArrayList<Character> data )
    {
        if ( !data.isEmpty() ) {
            System.out.println(
                    "Items are in collection using for loop: "
            );
            for ( int i = 0; i < data.size(); i++ ) {
                System.out.print(data.get(i) + " ");
            }
        }
    }
    // using Iterator
    public static void displayNameOfProcessingMethodNumberTwo
    ( ArrayList<Character> data )
    {
        if ( !data.isEmpty() ) {
            Iterator<Character> iterator = data.iterator();
            System.out.println(
                    "Items are in collection using Iterator: "
            );
            while ( iterator.hasNext() ) {
                System.out.print(iterator.next() + " ");
            }
        }

    }
    // using for-each loop
    public static void displayNameOfProcessingMethodNumberThree
    ( ArrayList<Character> data )
    {
        if ( !data.isEmpty() ) {
            System.out.println(
                "Items are in collection using for-each loop: "
            );
            for ( Character character : data ) {
                System.out.print(character + " ");
            }
        }
    }
    // using Java 8 new feature
    // for each method and lambda
    public static void displayNameOfProcessingMethodNumberFour
    ( ArrayList<Character> data )
    {
        if ( !data.isEmpty() ) {
            System.out.println(
                "Items are in collection using Java 8 new feature," +
                        " for each method and lambda: "
            );
            data.forEach( (item) -> {
                System.out.print( item + " " );
            } );
        }
    }
    // for each method and method reference
    public static  void displayNameOfProcessingMethodNumberFive
    ( ArrayList<Character> data )
    {
        if ( !data.isEmpty() ) {
            System.out.println(
                "Items are in collection using Java 8 new feature," +
                        " for each method and method reference: "
            );
            data.forEach( System.out::println );
        }
    }

    // display elements reversely using for loop
    public static void displayReverseNameOfProcessingMethod
    ( ArrayList<Character> data )
    {
        if ( !data.isEmpty() ) {
            System.out.println(
                    "Items are in collection reversely: "
            );
            for ( int i = data.size() - 1; i >= 0; i-- ) {
                System.out.print(data.get(i) + " ");
            }
        }
    }
    // check if a string is a Palindrome
    public static void testIfPalindromeNameOfProcessingMethod
    ( ArrayList<Character> data )
    {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilderReserved = new StringBuilder();

        for ( int i = 0; i < data.size(); i++ ) {
            stringBuilder.append( data.get(i) );
        }

        for ( int i = data.size() - 1; i >= 0; i-- ) {
            stringBuilderReserved.append( data.get(i) );
        }

        String str1 = stringBuilder.toString();
        String str2 = stringBuilderReserved.toString();

        if ( str1.equals( str2 ) ) {
            System.out.println("A Palindrome");
        } else {
            System.out.println("Not A Palindrome");
        }

    }

    public static void main(String args[]) throws IOException {

        // Create new ArrayList.
        ArrayList<Character> data = new ArrayList<>();
        char c;
        c = (char) bufferedReader.read();
        while( c != 'q' ) {

            add(data, c);
            c = (char) bufferedReader.read();

        }

        // for loop
        displayNameOfProcessingMethod(data);
        System.out.println();

        // iterator
        displayNameOfProcessingMethodNumberTwo(data);
        System.out.println();

        // for each loop
        displayNameOfProcessingMethodNumberThree(data);
        System.out.println();

        // for each method plus lambda
        displayNameOfProcessingMethodNumberFour(data);
        System.out.println();

        // for each and method reference
        displayNameOfProcessingMethodNumberFive(data);
        System.out.println();

        // reverse
        displayReverseNameOfProcessingMethod(data);
        System.out.println();

        // test palindrome
        testIfPalindromeNameOfProcessingMethod(data);

    }
}
