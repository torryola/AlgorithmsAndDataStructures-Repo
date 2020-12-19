package net.torrypubrepo.Algorithms.Sorting.QuickSort;

public class QuickSort_Impl {

    public static void main(String[] args)
    {
        int[] unsortedArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};

        quickSort(unsortedArray, 0, unsortedArray.length);

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");

    }

    static void quickSort(int[] arg, int startIndex, int endIndex)
    {
        // Base Case
        if (endIndex - startIndex < 2)   // We can't partition any further
           return;

        // Find the pivot index to get the picot value for comparison
        int pivotIndex = getPivotIndex(arg, startIndex, endIndex);
        // Use the pivot to sort
        quickSort(arg, startIndex, pivotIndex); // For Left Partition of the Array
        quickSort(arg, pivotIndex + 1, endIndex); // For Right Partition of the array
    }

    private static int getPivotIndex(int[] arg, int startIndex, int endIndex)
    {
        int pivotVal = arg[startIndex]; // Our Pivot Value is chosen to be the 1st element in the arg[]
        int i = startIndex;
        int j = endIndex;

        // Traverse from left to right and Right to Left and compare each element with the pivot
        while (i < j)
        {
            // Right Traverse
            while (i < j && (arg[--j] >= pivotVal)); // Do nothing because the element is on the right-side of the pivot
            // If there is an element smaller than the pivot on the right-side of the pivot, move it to left-side
            if (i < j)
                arg[i] = arg[j];

            // Left Traverse
            while (i < j && (arg[++i] <= pivotVal)); // Do nothing because the element is on the left-side of the pivot
            // If there is an element greater than the pivot on the left-side of the pivot, move it to the right-side
            if (i < j)
                arg[j] = arg[i];

        }//End Outer while

        // Move pivot to the right-side of the sorted array/sub-array
        arg[j] = pivotVal;
        // Return the index of the pivot
        return j;
    }
}
