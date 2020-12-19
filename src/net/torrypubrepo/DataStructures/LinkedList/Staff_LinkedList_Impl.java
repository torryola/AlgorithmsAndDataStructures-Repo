package net.torrypubrepo.DataStructures.LinkedList;

import net.torrypubrepo.Staff;

/*
 Created by Toriola

 Custom Implementation of the Linked List for the Staff object.

 Head is only reference we need, because to traverse the node for insertion, deletion etc, we start from the Head
 */
public class Staff_LinkedList_Impl
{
    // Linked List Head
    private StaffNode headNode;
    private int size;

    // Operations
    public void addToFront(Staff staff)
    {
        // Create new Node
        StaffNode newNode = new StaffNode(staff);
        /* Because we are inserting to the front of the List,
        current head will be next head to the new Node
        and new Node will be the Head
        */
        newNode.setNextNode(headNode);
        headNode = newNode;

        // Increment the Size of the List
        size++;
    }//End addToFront

    // Delete from front
    public StaffNode deleteFromFront()
    {
        // Check for null
        if (isEmpty())
            return null;

        StaffNode removeNode = headNode;
        headNode = removeNode.getNextNode();
        // Decrement the size;
        size--;
        // clear the reference to the removed Node
        removeNode.setNextNode(null);
        return removeNode;
    }

    // get the Size of the List
    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return headNode == null;
    }

    // Print Out the Content
    public void printList()
    {
        // Start from the Head
        StaffNode current = headNode;
        System.out.print("Head --> ");
        while (current != null)
        {
            System.out.print(current);
            System.out.print(" --> ");

            current = current.getNextNode();
        }
        System.out.print(" Null");
    }

}//End Staff_LinkedList_Impl Class
