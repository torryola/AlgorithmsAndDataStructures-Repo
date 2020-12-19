package net.torrypubrepo.Algorithms.Sorting.MergeSort;

import java.util.Arrays;

public class MergeSort_DescOrder_Impl {

    public static void main(String[] args)
    {
        int[] unsortedArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};
        // Split
        // MergeAndSort
        splitAndMerge(unsortedArray, 0, unsortedArray.length);
        // Print Sorted Array
        Arrays.stream(unsortedArray).forEach(i -> System.out.print(i+" "));
    }

    // Helper Method for splitting
    static void splitAndMerge(int[] arg, int start, int end)
    {
        // Base case ==> When start and end are equal
        if (end - start < 2)
            return;
        // Calculate the Mid
        int mid = (end + start) / 2;

        splitAndMerge(arg, start, mid); // Left Portion Splitting

        splitAndMerge(arg, mid, end);  // Right Portion splitting

        // Do the Merging After Splitting
        merge(arg, start, mid, end);
    }

    private static void merge(int[] arg, int start, int mid, int end)
    {
        // Temp Array for Sorting before Copying to Original Array
        int[] tempSortedArray = new int[end - start];

        int left = start;
        int right = mid;
        int tempIndex = 0; // For keeping the tracks of index in tempSortedArray

        /* Sort Siblings e.g. if siblings = 2 mid = 1 i.e. the 1st element in the right partition
         and mid - 1 is 1st element in the left partition
         arg[mid -1] technically means the element on the left is sorted
         */
        if (arg[mid - 1] >= arg[mid]) // Do nothing, is already sorted. <= Makes this Stable as order is preserved
            return;
        while (left < mid && right < end)
            tempSortedArray[tempIndex++] = arg[left] >= arg[right] ? arg[left++] : arg[right++];

        // Handle LeftOver elements
        /*
         If there elements left in the right array we don't need to do anything
         Otherwise, it means they are larger than the elements in the right array.
         So, we need to copy them in to the Original Array as there position won't change if we copy them into the tempSortedArray first
         and copy them back. They will always be at the back of all the elements in the temSortedArray
         */
        // Copy the Left leftovers to the original array
        /*
         left -  is the starting index of the leftover of the left array partition
         arg - is the source and destination
         start + tempIndex - the starting index where the elements to be copied will stat from in the arg[]
         i.e. the total length copied before while loop terminated
         mid - left - is the size of the elements left in the left partition array to be copied to arg[]
         */
        System.arraycopy(arg, left, arg, start + tempIndex, mid - left);

        // Copy from temSortedArray to original array arg[]
        // tempIndex - total number of the elements copied to temSortedArray
        System.arraycopy(tempSortedArray, 0, arg, start, tempIndex);
    }
}
