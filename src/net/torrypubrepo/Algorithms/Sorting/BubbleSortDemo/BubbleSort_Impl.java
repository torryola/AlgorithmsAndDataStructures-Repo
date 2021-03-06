package net.torrypubrepo.Algorithms.Sorting.BubbleSortDemo;

/*
 Created by Toriola
 This is the demo of Bubble sort Algorithm implementation in Java

 n -> number of elements
    Sorting requires 2 loops. For brevity, a loop takes linear time i.e o(n)
    Having nested loops means o(n) * o(n) so Time Complexity of of O(n**2) i.e. n to power of 2. which Quadratic

    Sorting from Right to Left, because we are moving the elements towards the end of the array.
 */
public class BubbleSort_Impl
{
    public static void main(String[] args)
    {
        // Array to sort
        int[] unsortedArray = {-3, 12, 45, 23, 6, -4, -6, 10, 1, 8};
        // Begin Sorting
        for (int unsortedIndexStart = unsortedArray.length - 1; unsortedIndexStart > 0; unsortedIndexStart--) // takes n-time
        {
            for (int j = 0; j < unsortedIndexStart; j++) // takes another n-time
                if (unsortedArray[j] > unsortedArray[j + 1])
                    swap(unsortedArray, j, j + 1);

        }//End Outer for

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");
    }

    // Helper Method to Swap element of unsortedArray
    /*
     This method will be used to swap an element of array to achieve the sorting
     @ arrayToSort : Array of partly sorted
     @ index1 : the first index to get the 1st item for swap
     @ index2 : the second index to get item to compare with the 1st item to
     @ tempHolder : is required to place one of the items to before it can be replaced
     */
    private static void swap(int[] arrayToSort, int index1, int index2)
    {
        if (arrayToSort[index1] == arrayToSort[index2]) // Swap not required
            return;
        int tempHolder = arrayToSort[index1];
        arrayToSort[index1] = arrayToSort[index2];
        arrayToSort[index2] = tempHolder;
    }

}//End BubbleSort_Impl
