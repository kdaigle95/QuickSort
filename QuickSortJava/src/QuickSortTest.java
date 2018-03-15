/*******************************************************************
*   QuickSortTest.java
*   Kyle Daigle
*   CS317
*   Project 1
*   Due Date: 2/27/18
*
*   This program is entirely my own work
*******************************************************************/


public class QuickSortTest {
    
    public static void main(String[] args)
    {
        double[] test = new double[]{ 17.8, 52.5, 1.25, 94.5, 3.4, 3.4, 2.02, 19.6, 66.7, 57.9 };
        double[] test2 = new double[]{ 10.0, 5.0, 1.0, 9.5, 3.4, 4.4, 2.02, 7.6, 6.7, 8.9 };
        //test = { 17.8, 52.5, 1.25, 94.5, 3.4, 3.4, 2.02, 19.6, 66.7, 57.9 };
        QuickSort qs1 = new QuickSort();
        qs1.readFile();
        //qs1.printAll();
        //System.out.println("-----");
        qs1.sort(0, qs1.getSize()-1);
        //qs1.sort(20, 40);
        qs1.printAll();
        qs1.writeFile();
    }
    
}
