package StopWatch;

import java.util.Arrays;
import java.util.Random;

//With quicksort gives time of approx: .012
//With insertionSort() gives time of approx: .79
public class StopWatchTest {

    public static void main(String[] args) {
        StopWatch timer = new StopWatch();
        Random random = new Random();

        timer.reset();
        timer.start();

        //array size 100,000
        int arraySize = 100000;
        int[] array = new int[arraySize];


        //fill the array with values between 1-100
        for(int i = 0; i < arraySize; i++) {
            array[i] = (random.nextInt(100) + 1);
        }

        timer.stop();
        System.out.println("Array size: " + arraySize);
        System.out.println("Array setup: " + timer.getTime() / 1000 + " seconds");
        timer.reset();

        //Start the timing then sort the array and search the array
        timer.start();

        //The Arrays.sort uses quicksort for primitives, mergesort for objs
        Arrays.sort(array);
        int x = binarySearch(array,34, arraySize);

        timer.stop();

        //Print out the time taken, and the location of specified value
        System.out.println("Search & Sort: " + timer.getTime() / 1000 + " seconds");
        System.out.println("Location of value: " + x);
        System.out.println();
        timer.reset();

    }

    public static void insertionSort(int[] array, int arraySize) {

        // For sorting in ascending order
        // Accepts an array of integers and sorts them in ascending order.
        // loop counter, variable to scan, variable to hold first unsorted value
        int index;
        int scan;
        int unsortedVal;

        // This loop steps the index variable through each subscript
        // in the array started at 1, since element 0 is considered sorted.
        // The first element outside the sorted subset is array[index]
        for (index = 1; index < arraySize; index++) {
            unsortedVal = array[index];
            scan = index;

            // Move the first element outside the sorted subset
            while (scan > 0 && array[scan - 1] > unsortedVal) {
                array[scan] = array[scan - 1];
                scan = scan - 1;
            }
            // Insert the unsorted value into its correct location
            array[scan] = unsortedVal;
        }
    }

    public static int binarySearch(int[] array, int value, int arraySize) {

        // Binary search algorithm
        //ARRAY HAS TO BE SORTED FIRST
        // Variable holds the first subscript
        // IF search is unsuccessful then returns -1
        int first = 0;

        // Variable to hold the subscript of the rightmost element.
        int last = arraySize - 1;

        // Position of the search value
        int position = -1;

        // Flag
        boolean found = false;

        // Variable to hold the subscript of the midpoint
        int middle;

        while (!found && first <= last) {
            // Find the midpoint
            middle = (first + last) / 2;

            // Check if the value was found
            if (array[middle] == value) {
                found = true;
                position = middle;
            }
            else if (array[middle] > value) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }
        return position;

    }
}