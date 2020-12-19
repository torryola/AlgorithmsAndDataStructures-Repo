package net.torrypubrepo.DataStructures.HashTable;

import net.torrypubrepo.Staff;

import java.util.LinkedList;
import java.util.ListIterator;

/*
 Created by Toriola
 Implementation of HshTable with LinkedList.
 LinkedList chained nodes hence the name Chaining.
 if there is hashKey collision, the objects will be chained in the LinkedList instead of Linearly probing i.e. rehashing
 till unique key is created
 */
public class ChainedHashTable_Impl
{
    private LinkedList<SavedStaff>[] linkedStaff_List;

    public ChainedHashTable_Impl()
    {
        linkedStaff_List = new LinkedList[10];
        // Initialize
        for (int i = 0; i < linkedStaff_List.length; i++) {
            linkedStaff_List[i] = new LinkedList<SavedStaff>();
        }
    }

    // Helper method for generating hash Key which equivalents to the index the obj will be inserted into.
    private int hashKey(String key)
    {
        // E.g. for key length 6 % 10 = 6; so the object will be inserted at index 1.
        return key.length() % linkedStaff_List.length;
    }

    public void put(String key, Staff staff)
    {
        int newKey = hashKey(key);
        if (linkedStaff_List[newKey] != null)
            linkedStaff_List[newKey].add(new SavedStaff(key, staff));
    }

    public Staff get(String key)
    {
        int iKey = hashKey(key);
        // Iterate through the LinkedList for the Value
        ListIterator<SavedStaff> iterator = linkedStaff_List[iKey].listIterator();
        SavedStaff tempStaff = null;
        while (iterator.hasNext())
        {
            tempStaff = iterator.next();
            if (tempStaff.key.equals(key))
                return tempStaff.staff;
        }
        return null;
    }

    public Staff remove(String key)
    {
        int iKey = hashKey(key);
        // Iterate through the LinkedList for the Value
        ListIterator<SavedStaff> iterator = linkedStaff_List[iKey].listIterator();
        SavedStaff tempStaff = null;
        while (iterator.hasNext())
        {
            tempStaff = iterator.next();
            if (tempStaff.key.equals(key))
                break; // Found what we are looking for
        }

        if (tempStaff == null || !tempStaff.key.equals(key))
            return null;
        else
        {
            // Remove the node from the LinkedList
            linkedStaff_List[iKey].remove(tempStaff);
            return tempStaff.staff;
        }

    }

    public void print()
    {
        for (int i = 0; i < linkedStaff_List.length; i++)
        {
            if (linkedStaff_List[i].isEmpty())
                System.out.print("Position : " + i + " Empty");
            else {
                // Iterate through each LinkedList
                ListIterator<SavedStaff> iterator = linkedStaff_List[i].listIterator();
                while (iterator.hasNext())
                {
                    System.out.print("-> "+iterator.next().staff);
                    System.out.print("->");
                }
                System.out.print("null");
            }
        }
    }
}//End ChainedHashTable_Impl
