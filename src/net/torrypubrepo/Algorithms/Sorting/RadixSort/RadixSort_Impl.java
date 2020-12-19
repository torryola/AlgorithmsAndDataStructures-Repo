package net.torrypubrepo.Algorithms.Sorting.RadixSort;

import java.util.Arrays;

public class RadixSort_Impl {

    public static void main(String[] args)
    {
        int[] unsortedArray = {4512, 3467, 4005, 2903, 6000, 4243, 6476, 1002, 1983, 8637};

        // Width is the length of each value in the array
        // Radix is the digit range i.e. 0-9
        radixSort(unsortedArray, 10, 4);

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");

    }//End main

    static void radixSort(int[] array, int radix, int width)
    {
        for (int i = 0; i < width; i++) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(int[] array, int position, int radix) {
        // Number of Items to Sort
        int numItems = array.length;
        // Temp Array to do the count large enough to hold the radix
        int[] countArray = new int[radix];

        // For every Value on the Array, we going to count How many values have a certain digit
        for (int value : array)
            countArray[getDigit(position, value, radix)]++;
        System.out.println(" Current countArray value : "+ Arrays.toString(countArray));

        // Adjust the countArray instead of raw Array
        for (int i = 1; i < radix ; i++)
        {
            countArray[i] += countArray[i - 1];
        }
        System.out.println(" Current countArray value After Adjustment : "+ Arrays.toString(countArray));

        // Copy the value into the temp Array
        int[] tempArray = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            tempArray[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        // Copy every items from tempArray to the Input Array i.e. array
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }

    private static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }

}//End RadixSort_Impl
