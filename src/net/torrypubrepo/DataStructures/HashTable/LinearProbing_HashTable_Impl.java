package net.torrypubrepo.DataStructures.HashTable;

import net.torrypubrepo.Staff;

import java.util.stream.IntStream;

/*
 Created by Toriola
 */
public class LinearProbing_HashTable_Impl
{
    private SavedStaff[] hashTable;

    public LinearProbing_HashTable_Impl()
    {
        // Initialize the array size, It's better to use the size that wont result to resizing often but
        // simplicity, 10 will do
        hashTable = new SavedStaff[10];
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
        // Perform Linear Probing
        if (isOccupied(keyIndex))
        {
            // Set Stop index
            int stopIndex = keyIndex;
            if (keyIndex == hashTable.length - 1) // Reach the end of the array
                keyIndex = 0; // go back to the 1st index
            else
                keyIndex++; // Increment Instead

            // Look for empty index
            while (isOccupied(keyIndex) && keyIndex != stopIndex)
            {
                // E.g if the current index is 6, next index (6 +1) -> 7%10 = 7;
                keyIndex = (keyIndex +1) % hashTable.length;
            }
        }//End if

        if (isOccupied(keyIndex))
            System.out.println("Can't insert, index occupied already ");
        else
            hashTable[keyIndex] = new SavedStaff(key, staff1);
    }

    private boolean isOccupied(int key)
    {
        return hashTable[key] != null;
    }

    // Method for getting value associated to a key
    public Staff get(String key)
    {
        int hashedKey = findKey(key);
       if (hashedKey == -1)
           return null;
       else
        return hashTable[hashedKey].staff;
    }

    public Staff remove(String key)
    {
        int iKey = findKey(key);
        if (iKey == -1)
            return null;
        else{
            Staff staff = hashTable[iKey].staff;
            hashTable[iKey] = null;
            // ReHash the Table to avoid collision and/or unreachable value @ get() because we set the removed Value here to null
            SavedStaff[] oldHashTable = hashTable;
            hashTable = new SavedStaff[oldHashTable.length];
            // copy old Values to new value
            for (int i = 0; i < oldHashTable.length; i++)
            {
                if (oldHashTable[i] != null)
                    put(oldHashTable[i].key, oldHashTable[i].staff);
            }

            return staff;
        }
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);
        if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key))
            return hashedKey;

            int stopIndex = hashedKey;
            if (hashedKey == hashTable.length - 1)
                hashedKey = 0;
            else
                hashedKey++;
            while (hashedKey != stopIndex && hashTable[hashedKey] != null &&
                        !hashTable[hashedKey].key.equals(key)) {
                hashedKey = (hashedKey + 1) % hashTable.length;
            }
            if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key))// We found the key
                return hashedKey;
            else
                return -1;
    }

    public void printHashTable()
    {
        IntStream.range(0, hashTable.length)
                .filter(i -> hashTable[i] != null)
                .forEach(i -> System.out.println(hashTable[i].staff));
    }

}//End BasicHashTable_Impl
