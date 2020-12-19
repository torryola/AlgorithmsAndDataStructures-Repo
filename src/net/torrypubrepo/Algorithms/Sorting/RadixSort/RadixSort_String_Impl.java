package net.torrypubrepo.Algorithms.Sorting.RadixSort;

import java.util.Arrays;

public class RadixSort_String_Impl {

    public static void main(String[] args)
    {
        String[] unsortedArray = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        // Width is the length of each value in the array
        // Radix is the digit range i.e. 0-9
        radixSort(unsortedArray, 'a', 5);

        // Print Sorted Array
        for (String i : unsortedArray)
            System.out.print(i+ " ");

    }//End main

    static void radixSort(String[] array, int radix, int width)
    {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(array, i, radix);
        }
    }

    private static void radixSingleSort(String[] array, int position, int radix) {
        // Number of Items to Sort
        int numItems = array.length;
        // Temp Array to do the count large enough to hold the radix
        int[] countArray = new int[radix];

        // For every Value on the Array, we going to count How many values have a certain digit
        for (String value : array)
            countArray[getIndex(position, value)]++;
        System.out.println(" Current countArray value : "+ Arrays.toString(countArray));

        // Adjust the countArray instead of raw Array
        for (int i = 1; i < radix ; i++)
        {
            countArray[i] += countArray[i - 1];
        }
        System.out.println(" Current countArray value After Adjustment : "+ Arrays.toString(countArray));

        // Copy the value into the temp Array
        String[] tempArray = new String[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--)
        {
            tempArray[--countArray[getIndex(position, array[tempIndex])]] = array[tempIndex];
        }

        // Copy every items from tempArray to the Input Array i.e. array
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }

    private static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
    }

}//End RadixSort_Impl
