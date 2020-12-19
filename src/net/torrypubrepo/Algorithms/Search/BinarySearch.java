package net.torrypubrepo.Algorithms.Search;

import java.util.Arrays;
import java.util.Collections;

/*
 Created by Toriola
 */
public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] inputArray = {1,2,3,4,5,6,7,8,9,10}; //{12, 3, 45, 23, 6, -4, -6, 10, 1, 8};
        int num = -2;
       // System.out.println(num +" is found at index : "+iterativeBinarySearch(inputArray, num));
        System.out.println(num +" is found at index : "+recursiveBinarySearch(inputArray, num));
    }

    private static int iterativeBinarySearch(int[] inputArray, int val)
    {
        int start = 0;
        int end = inputArray.length;
        while (start < end)
        {
            // Find MidPoint
            int mid = (end + start) / 2;
            System.out.println("Midpoint : "+mid);
            if (inputArray[mid] == val)
                return mid;
            else if (inputArray[mid] < val) // Value is on the right
                start = mid + 1; // Move towards right
            else
                end = mid; // Move towards left
        }
        return -1;
    }//End iterativeBinarySearch

    private static int recursiveBinarySearch(int[] inputArray, int val)
    {
        return recursiveBinarySearch(inputArray, 0, inputArray.length, val);
    }

    private static int recursiveBinarySearch(int[] inputArray, int start, int end, int val)
    {
        //Base case
        if (start >= end)
            return -1;
        // Calculate Midpoint
        int mid = (end + start) / 2;
        if (inputArray[mid] == val)
            return mid;
        else if (inputArray[mid] < val)
            return recursiveBinarySearch(inputArray, mid + 1, end, val);
        else
            return recursiveBinarySearch(inputArray, start, mid, val);
    }

}//End BinarySearch
