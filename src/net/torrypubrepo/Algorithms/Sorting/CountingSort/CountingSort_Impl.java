package net.torrypubrepo.Algorithms.Sorting.CountingSort;

public class CountingSort_Impl {

    public static void main(String[] args)
    {
        int[] unsortedArray = {12, 3, 45, 23, 6, 4, 6, 2, 10, 8};
        /*
         max -  is the largest Value in the array elements not the array-size i.e. 45
         min - value > 0 and <= the smallest value in the array
         in this case min value can be 1 or 2
         */
        countingSort(unsortedArray, 2, 45);

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");
    }

    private static void countingSort(int[] unsortedArray, int min, int max)
    {
        /* Create the Temp Array for Counting items in the unSortedArray
         The temp Array should be enough to hold the count
         */
        int[] countArray = new int[(max - min) + 1];

        /* Traverse the unsortedArray and Count each element occurrence at the corresponding index in the countArray
         E.g if the item is 5 in the UnsortedArray, its index will be 4 in countArray
         And increment the value returned

         */
        for (int i = 0; i < unsortedArray.length; i++)
            countArray[unsortedArray[i] -min]++; // Increment the the returned Value

        // Sort the Value using the Number of counts for each elements in the countArray
        // i is to min i.e. 1
        int j = 0; // Starting index for the unsortedArray
        for (int i = min; i <= max; i++)
        {
            while (countArray[i - min] > 0)
            {
                unsortedArray[j++] = i; // Set the Value and Increment the index
                // Decrement the Values in the countArray
                countArray[i - min]--;
                //j++;
            }//for while
        }//for

    }
}
