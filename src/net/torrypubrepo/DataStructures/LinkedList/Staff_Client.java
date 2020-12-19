package net.torrypubrepo.DataStructures.LinkedList;

import net.torrypubrepo.Staff;

/*
 Created by Toriola
 */
public class Staff_Client
{
    public static void main (String[] args)
    {
        Staff_LinkedList_Impl staffLinkedList = new Staff_LinkedList_Impl();

        // Create Sample Staff Objects
        Staff conner = new Staff("Conner","Mario",123);
        Staff john = new Staff("John", "McCanny", 1029);
        Staff billy = new Staff("Billy", "Jones", 4537);

        System.out.println("List Empty : "+staffLinkedList.isEmpty());

        // Add Staff objects to Staff_LinkedList
        staffLinkedList.addToFront(conner);
        staffLinkedList.addToFront(john);
        staffLinkedList.addToFront(billy);

        System.out.println("List Empty : "+staffLinkedList.isEmpty() + " After Adding Objects to the List");

        System.out.println("List Size : "+staffLinkedList.getSize());

        // Print Staff Details
        staffLinkedList.printList();

        System.out.println();
        // Remove an Element from the front
        System.out.println("Node Removed is : "+staffLinkedList.deleteFromFront().toString());

        System.out.println();
        System.out.println("List Size : "+staffLinkedList.getSize());

        // Print Staff Details
        staffLinkedList.printList();

    }//End main

}//End Staff_Client
