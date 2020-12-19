package net.torrypubrepo.DataStructures.Stack.LinkedListBacked;

import net.torrypubrepo.Staff;

import java.util.LinkedList;
import java.util.ListIterator;

/*
 Custom Implementation of Stack using  JDK LinkedList to expose few methods
 */

public class LinkedStack_Impl {

    private LinkedList<Staff> staffStack;

    public LinkedStack_Impl()
    {
        staffStack = new LinkedList<>();
    }

    public void push(Staff newStaff)
    {
        staffStack.push(newStaff);
    }
    public Staff pop()
    {
        return staffStack.pop();
    }

    public Staff peek()
    {
        return staffStack.peek();
    }

    public boolean isEmpty()
    {
        return staffStack.isEmpty();
    }

    public void printStack()
    {
        ListIterator<Staff> iterator = staffStack.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}//End LinkedStack_Impl
