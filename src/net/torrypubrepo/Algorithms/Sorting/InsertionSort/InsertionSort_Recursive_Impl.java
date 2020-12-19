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
public class InsertionSort_Recursive_Impl
{
    public static void main(String[] args)
    {
        /*
         Insertion Sort the 1st element i.e. @ index 0 is considered to be sorted
         */
        // Array to sort
        int[] unsortedArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};

           // recursiveInsertionSort2(unsortedArray, unsortedArray.length);
            recursiveInsertionSort(unsortedArray, 1);

        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");
    }//End Main


    static void recursiveInsertionSort(int[] array, int startIndex)
    {
        if (startIndex == array.length)
            return;

        int tempElem = array[startIndex]; // Save the Item in the First Index to tempElem Variable
        int j;

        // Look for the Largest element from left(Sorted) to right and do the insertion
        for (j = startIndex; j > 0 && array[j - 1] > tempElem; j--) // takes another n-time
        {
            // Shift Element to the right
            array[j] = array[j - 1];
        }

        // Insert the largest element into the new index
        array[j] = tempElem;

        recursiveInsertionSort(array, startIndex+=1);

    }//End recursiveInsertionSort

    static void recursiveInsertionSort2(int[] array, int startIndex)
    {
        if (startIndex < 2)
            return;

        recursiveInsertionSort2(array, startIndex - 1);

        int tempElem = array[startIndex - 1]; // Save the Item in the First Index to tempElem Variable
        int j;

        // Look for the Largest element from left(Sorted) to right and do the insertion
        for (j = startIndex - 1; j > 0 && array[j - 1] > tempElem; j--) // takes another n-time
        {
            // Shift Element to the right
            array[j] = array[j - 1];
        }

        // Insert the largest element into the new index
        array[j] = tempElem;

    }//End recursiveInsertionSort2

}//End BubbleSort_Impl
