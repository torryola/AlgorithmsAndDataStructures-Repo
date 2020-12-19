package net.torrypubrepo.DataStructures.HashTable;

import net.torrypubrepo.Staff;

import java.util.stream.IntStream;

/*
 Created by Toriola Dec
 */
public class BasicHashTable_Impl
{
    private Staff[] hashTable;

    public BasicHashTable_Impl()
    {
        // Initialize the array size, It's better to use the size that wont result to resizing often but
        // simplicity, 10 will do
        hashTable = new Staff[10];
    }

    // Helper method for generating hash Key which equivalents to the index the obj will be inserted into.
    private int hashKey(String key)
    {
        // E.g. for key length 6 % 10 = 6; so the object will be inserted at index 1.
        return key.length() % hashTable.length;
    }

    // Method for inserting into our hashTable
    public void put(String key, Staff staff1)
    {
        int keyIndex = hashKey(key);
        if (hashTable[keyIndex] != null)
            System.out.println("Can't insert, index occupied already ");
        else
            hashTable[keyIndex] = staff1;
    }

    // Method for getting value associated to a key
    public Staff get(String key)
    {
        int hashedKey = hashKey(key);
        return hashTable[hashedKey];
    }

    public void printHashTable()
    {
        IntStream.range(0, hashTable.length)
                .forEach(i -> System.out.println(hashTable[i]));
    }
}//End BasicHashTable_Impl
