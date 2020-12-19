package net.torrypubrepo.DataStructures.DoublyLinkedList;

import net.torrypubrepo.Staff;

/*
 Created by Toriola

 Custom Implementation of the Doubly Linked List for the Staff object.

 Head and Tail references are required to traverse both ways
 */
public class Staff_Doubly_LinkedList_Impl
{
    // Linked List Head
    private StaffNode headNode;
    // Linked List Tail
    private StaffNode tailNode;
    private int size;

    // Operations
    public void addToFront(Staff staff)
    {
        // Create new Node
        StaffNode newNode = new StaffNode(staff);
        /* Because we are inserting to the front of the List,
        current head will be next head to the new Node
        and new Node will be the Head
        Adjust the previous Node
        */
        // If list is empty
        if (isEmpty()) // i.e. if the list is empty
        {
            tailNode = newNode;
        }
        else
        {
            newNode.setNextNode(headNode);
            headNode.setPreviousNode(newNode);
        }
        headNode = newNode;

        // Increment the Size of the List
        size++;
    }//End addToFront

    public boolean addBefore(Staff newStaff, Staff existingStaff)
    {
        // Existing Node
        StaffNode exNode = new StaffNode(existingStaff);
        // Create new Node
        StaffNode exNodePrev = exNode.getPreviousNode();

        /* Because we are inserting to the front of the List,
        current head will be next head to the new Node
        and new Node will be the Head
        Adjust the previous Node
        */
        // If list is empty
        if (isEmpty())
            return false;
        else
        {
            StaffNode current = headNode;
            // Traverse list till we find the exNode
            while (current != null && !current.getStaff().equals(exNode.getStaff()))
            {
                current = current.getNextNode();
            }//End while

            if (current == null)
                return false;
            StaffNode newNode = new StaffNode(newStaff);
            newNode.setPreviousNode(current.getPreviousNode());
            newNode.setNextNode(current);
            current.setPreviousNode(newNode);

            if (headNode == current)
                headNode = newNode;
            else
                newNode.getPreviousNode().setNextNode(newNode);
            // Increment the Size of the List
            size++;

            return true;
        }
    }//End addBefore

    public void addToEnd(Staff staff)
    {
        // Create new Node
        StaffNode newNode = new StaffNode(staff);

        newNode.setNextNode(null);
        // If list is empty
        if (isEmpty() || tailNode == null) // i.e. if the list is empty
        {
            headNode = newNode;
        }
        else
        {
            tailNode.setNextNode(newNode);
            newNode.setPreviousNode(tailNode);
        }
        tailNode = newNode;

        // Increment the Size of the List
        size++;
    }//End addToTail

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

    // Delete from End
    public StaffNode deleteFromEnd()
    {
        if (isEmpty())
            return null;

        StaffNode removeNode = tailNode;
        if (tailNode.getPreviousNode() == null)
            headNode = null;
            // Adjust the Previous and Next
            tailNode.getPreviousNode().setNextNode(null);

            tailNode = tailNode.getPreviousNode();
            size--;
            return removeNode;
    }//End deleteFromEnd

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
        System.out.print("Head <--> ");
        while (current != null)
        {
            System.out.print(current);
            System.out.print(" <--> ");

            current = current.getNextNode();
        }
        System.out.print(" Null");
    }

}//End Staff_LinkedList_Impl Class
