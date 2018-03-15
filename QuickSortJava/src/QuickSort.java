/*******************************************************************
*   QuickSort.java
*   Kyle Daigle
*   CS317
*   Project 1
*   Due Date: 2/27/18
*
*   This program is entirely my own work
*******************************************************************/


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickSort 
{
    public int size; //store size of array
    double[] doubleArray; //array to be sorted
    public int ComparisonCount = 0; //number of comparisons made
    public int AssignmentCount = 0; //number of assignments made
    
    public QuickSort()
    {
        
    }
    
    public boolean lessThan(double a, double b)
    {
        ComparisonCount++;
        if (a < b)
            return true;
        else
            return false;      
    }
    
    public boolean greaterThan(double a, double b)
    {
        ComparisonCount++;
        if (a > b)
            return true;
        else
            return false;
    }
    
    public boolean equal(double a, double b)
    {
        ComparisonCount++;
        if (a == b)
            return true;
        else
            return false;
    }
    
    public void sort(int left, int right)
    {
        int pivot;
	if (left < right)
	{
		pivot = partition(left, right); //find point for pivot
		sort(left, pivot - 1); //sort smaller arrays created by partition
		sort(pivot + 1, right); 
	}
    }
    
    public int partition(int left, int right)
    {
        int pivot = left;
        left++;

		do
		{

			while ((left <= right) && lessThan(doubleArray[left], doubleArray[pivot])) //left looking for value greater than or equal to pivot
			{
				left++;
			}
			while ((left <= right) && greaterThan(doubleArray[right], doubleArray[pivot])) //right looking for value less than or equal to pivot
			{
				right--;
			}
			if(left <= right)
			{
				swap(left, right);
				left++;   			
				right--;
			}

		}
		while (left <= right); //go until they cross

		swap(right, pivot); 

		return right; //pivot for sort function
    }
    
    public void swap(int a, int b)
    {
        double temp = 0; //temp variable for swapping
        temp = assign(temp, doubleArray[a]); //assign value of a to temp
        doubleArray[a] = assign(doubleArray[a], doubleArray[b]); //this was the only way I could make this work
        doubleArray[b] = assign(doubleArray[b], temp); //I hope it is ok
    }
    
    public double assign(double a, double b)
    {
        a = b;
        AssignmentCount++;
        return a;
    }
    
    public void printAll()
    {
        for(int i = 0; i < size; i++)
        {
            System.out.println(doubleArray[i]);
        }
        System.out.println("Comparisons made: " + ComparisonCount);
        System.out.println("Assignments made: " + AssignmentCount);
    }
    
    public void readFile()
    {
        File file = new File("input7.txt"); //read input for array
        
        try
        {
        Scanner input = new Scanner(file);
        
        size = input.nextInt(); //read first line for amount of doubles to be stored
        doubleArray = new double[size]; //initialize array big enough to hold all doubles
        for(int i = 0; i < size; i++)
         {
             doubleArray[i] = input.nextDouble(); //add values to array
         }
        }
        catch(IOException ex)
        {
            System.out.println("Reader exception");
        }
        
    }
    
    public void writeFile()
    {
        File file = new File("kad0011.txt"); //output file
        
        try
        {
         PrintWriter output = new PrintWriter(file);
         
         output.println("Comparisons counted: " + ComparisonCount); //write comparisonCount to file
         output.println("Assignments counted: " + AssignmentCount); //write assignmentCount to file

         for(int i = 0; i < size; i++)
         {
             output.println(doubleArray[i] + "\n"); //print sorted array to file
         }
         output.close();
        }
        catch (IOException ex)
        {
            System.out.println("ERROR: IOException write");
        }
    }
    
    public int getSize()
    {
        return size;
    }
}
