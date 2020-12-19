package net.torrypubrepo.Algorithms.Search;

/*
 Created by Toriola
 */
public class LinearSearch
{
    public static void main(String[] args)
    {
        int[] inputArray = {12, 3, 45, 23, 6, -4, -6, 10, 1, 8};
        int num = 8;
        System.out.println(num +" is found at index : "+linearSearch(inputArray, num));
    }

    private static int linearSearch(int[] inputArray, int val)
    {
        for (int j = 0; j < inputArray.length; j++) {
            if (inputArray[j] == val)
                return j;
        }
        return -1;
    }

}//End LinearSearch
