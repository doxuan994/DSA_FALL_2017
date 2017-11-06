/*
 * Purpose: Data Structure and Algorithms Lab 5 Problem 2
 * Status: Complete and thoroughly tested
 * Last update: 10/07/17
 * Submitted:  10/10/17
 * Comment: test suite and sample run attached
 * @author: Xuan Do
 * @version: 2017.10.04
 */
public class Layer
{
    private int numItems = 0;
    private double weight = 0.0;

    public Layer( int numItems, double weight )
    {
        this.numItems = numItems;
        this.weight = weight;
    }

    public int getItems()
    {
        return this.numItems;
    }

    public void setItems( int numItems )
    {
        this.numItems = numItems;
    }

    public double getWeight()
    {
        return this.weight;
    }

    public void setWeight( double weight )
    {
        this.weight = weight;
    }
} // end class Layer