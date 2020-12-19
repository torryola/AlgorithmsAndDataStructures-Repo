package net.torrypubrepo.DataStructures.LinkedList;

import net.torrypubrepo.Staff;

/*
 Created by Toriola

 This is the Linked List Node representations and Inside the node we have the object to store
 and the reference to the next Node
 */
public class StaffNode
{
    // Staff Object Inside Node
    private Staff staff;
    // Ref to the Next Node
    private StaffNode nextNode;

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

    @Override
    public String toString() {
        return staff.toString();
    }
}//End StaffNode Class
