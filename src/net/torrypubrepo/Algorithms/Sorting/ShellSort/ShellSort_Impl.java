package net.torrypubrepo.Algorithms.Sorting.ShellSort;

/*
 Shell Sort Algorithm is a variation of Insertion sort.
 Basically, instead of starting from small gap i.e. 1 in insertion sort,
 Shell sort start from larger gap e.g. n/2 where is number of input array.

 Time Complexity:
  Time complexity of this algorithm depends on the method used in calculating the gap;
  Methods like
  - Shell's Original Sequence
  - Knuth's Increment
  - Sedgewick's Increment etc
  Work case complexity is said to be o(n to power of 2)
  Best and Average case complexity o(n*log n)
 */
public class ShellSort_Impl
{

    public static void main(String[] args)
    {
        int[] unsortedArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};

        // Calculate the Sequence or initial Gap
        for (int gap = unsortedArray.length/2; gap > 0; gap /= 2)
        {
            // Loop through the UnSorted Array starting from the Gap as opposed to 1 in Insertion Sort
            for (int i = gap; i < unsortedArray.length; i++)
            {
                // get the Elem in the gap index
                int tempElem = unsortedArray[i];
                int j = i;
                while (j >=gap && unsortedArray[j - gap] > tempElem) {
                    unsortedArray[j] = unsortedArray[j - gap];
                    j -= gap;
                }

                unsortedArray[j] = tempElem;
            }

        }//End outer for


        // Print Sorted Array
        for (int i : unsortedArray)
            System.out.print(i+ " ");
    }//End main
}
