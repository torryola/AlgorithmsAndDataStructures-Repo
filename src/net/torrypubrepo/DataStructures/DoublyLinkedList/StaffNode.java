package net.torrypubrepo.DataStructures.DoublyLinkedList;


import net.torrypubrepo.Staff;

import java.util.Objects;

/*
 Created by Toriola

 This is the Doubly Linked List Node representations and Inside the node we have the object to store in the List
 and the reference to both the next and the previous Node
 */
public class StaffNode
{
    // Staff Object Inside Node
    private Staff staff;
    // Ref to the Next Node
    private StaffNode nextNode;
    // Ref to the Previous
    private StaffNode previousNode;

    public StaffNode(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public StaffNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StaffNode nextNode) {
        this.nextNode = nextNode;
    }

    public StaffNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(StaffNode previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return staff.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffNode staffNode = (StaffNode) o;
        return staff.equals(staffNode.staff) &&
                nextNode.equals(staffNode.nextNode) &&
                previousNode.equals(staffNode.previousNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff, nextNode, previousNode);
    }
}//End StaffNode Class
