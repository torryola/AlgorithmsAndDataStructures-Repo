package net.torrypubrepo.Algorithms.Sorting.InsertionSort;

/*
 Created by Toriola
 This is the demo of Insertion sort Algorithm implementation in Java

 n -> number of elements

 Big-O Notation:
    Sorting requires 2 loops. For brevity, a loop takes linear time i.e o(n)
    Having nested loops means o(n) * o(n) so Time Complexity of of O(n**2) i.e. n to power of 2. which is Quadratic

    Sorting from Left to Right, because we are moving the elements towards the beginning of the array as the left side is
    assumed to be sorted
 */
public class InsertionSort_Impl
{
    public static void main(String[] args)
    {
        /*
         Insertion Sort the 1st element i.e. @ index 0 is considered to be sorted
         */
        // Array to sort
        int[] unsortedArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};
        // Begin Sorting
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < unsortedArray.length; firstUnsortedIndex++) // takes n-time
        {
            int tempElem = unsortedArray[firstUnsortedIndex]; // Save the Item in the First Index to tempElem Variable
            int j;

            // Compare the left(Sorted) to right and do the insertion appropriately
            for (j = firstUnsortedIndex; j > 0 && unsortedArray[j - 1] > tempElem; j--) // takes another n-time
            {
                // Insert Element to the right
                unsortedArray[j] = unsortedArray[j - 1];
            }
                // Insert the largest element into the new index
                unsortedArray[j] = tempElem;

        }//End Outer for

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");
    }//End Main

}//End BubbleSort_Impl
