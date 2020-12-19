package net.torrypubrepo.Algorithms.Sorting.BucketSort;

import java.util.*;
import java.util.stream.Collectors;

/*
 Created by Toriola Dec
 */
public class BucketSort_Impl
{
    public static void main(String[] args)
    {
        int[] unsortedArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};

        bucketSort(unsortedArray);

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i + " ");
    }

    private static void bucketSort(int[] unsortedArray)
    {
        // Create Buckets
        List<Integer>[] buckets = new List[unsortedArray.length];
        // Initialize each bucket
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new ArrayList<>();
            // Just as ArrayList is used, LinkedList/Vector can be used
           //buckets[i] = new LinkedList<>();
            //buckets[i] = new Vector<>();
        }
        // Traverse the unsortedArray to filter values into the appropriate buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[hash(i)].add(unsortedArray[i]);
        }

        // Sort each Bucket using JDK Collections Sort Util
        for (List<Integer> bucket : buckets)
            Collections.sort(bucket);

        int startIndex = 0;
        // Copy back the items in each bucket into the original array
        for (int i = 0; i < buckets.length; i++)
        {
            // loop through each bucket and add the item to the original array
            for (int item : buckets[i])
                unsortedArray[startIndex++] = item;
        }

    }

    /* Helper method for calculating bucket index thus the item range
     E.g. 54 will give 5 hence the 54 value will be inserted in the bucket @ index 5
     58 will give 5 so will be in the same bucket as 54
     75 will give 7 so it will be in the bucket index 7 etc.
     */
    private static int hash(int val)
    {
        return val / 10;
    }

} //End BucketSort_Impl
