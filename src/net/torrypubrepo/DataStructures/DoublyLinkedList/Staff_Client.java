package net.torrypubrepo.DataStructures.DoublyLinkedList;


import net.torrypubrepo.Staff;

/*
 Created by Toriola
 */
public class Staff_Client
{
    public static void main (String[] args)
    {
        Staff_Doubly_LinkedList_Impl staff_doubly_linkedList = new Staff_Doubly_LinkedList_Impl();

        // Create Sample Staff Objects
       Staff conner = new Staff("Conner","Mario",123);
       Staff john = new Staff("John", "McCanny", 1029);
       Staff billy = new Staff("Billy", "Jones", 4537);

        System.out.println("List Empty : "+staff_doubly_linkedList.isEmpty());

        // Add Staff objects to Staff_LinkedList
        staff_doubly_linkedList.addToFront(conner);
        staff_doubly_linkedList.addToFront(john);
        staff_doubly_linkedList.addToFront(billy);

        // Add to End
        staff_doubly_linkedList.addBefore(new Staff("James", "Owen", 4689), billy); // in position 2

        System.out.println("List Empty : "+staff_doubly_linkedList.isEmpty() + " After Adding Objects to the List");

        System.out.println("List Size : "+staff_doubly_linkedList.getSize());

        // Print Staff Details
        staff_doubly_linkedList.printList();

        // Add to End
        //staff_doubly_linkedList.addToEnd(new Staff("Malcom", "Owen", 9589));

        System.out.println();
        // Remove an Element from the front
      //  System.out.println("Node Removed is : "+staff_doubly_linkedList.deleteFromFront().toString());


        // Print Staff Details
        staff_doubly_linkedList.printList();

        System.out.println();
        // Remove an Element from the front
       // System.out.println("Node Removed is : "+staff_doubly_linkedList.deleteFromFront().toString());

    }//End main

}//End Staff_Client
