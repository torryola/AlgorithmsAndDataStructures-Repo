package net.torrypubrepo.DataStructures.Queue.CircularQueue;

import net.torrypubrepo.Staff;

import java.util.EmptyStackException;

/*
 Created by Toriola

 The Implementation of Queue backing it with the Array Data Structure
 Ideally, LinkedList is better, array can be used as well if the size of the elements in the Queue is known hence
 no resizing will be required otherwise the time complexity will be affected
 E.g. Resize Capacity means copying the old array into the new expanded array, thus worse case O(n)
 */
public class Circular_Queue_Impl
{
    // Object to queue
    Staff[] originalArray;
    private int front; // For tacking the size/front of the queue
    private int back;

    public Circular_Queue_Impl(int capacity)
    {
        // Initialize the size of Array
        originalArray = new Staff[capacity];
    }

    // Operations
    public boolean isEmpty()
    {
        // Stack is Empty if front is 0
        return size() == 0;
    }

    public int size()
    {  /*
         Because the back is circling back to front if there are empty spaces for memory optimization
         and we increment front on each item removed, front is likely to be bigger than back, hence
         we have to check if the front is bigger than the back to avoid a Runtime Exception
         */
        if (front <= back)
        return back  - front;
        else return back - front + originalArray.length;
    }

    public void add(Staff newStaff)
    {
        // For the queue, object is add from the back, thus back increment wth each addition/insert
        // Check the Size
        if (size() == originalArray.length - 1)
        {
            int numItem = size();
            /* Because we have to resize and copy the array elements makes worse case
             Time-Complexity O(n) as the number of steps depends on the size of the array
             */
            // Need to resize the array
            Staff[] newArrayStaff = new Staff[ 2 * originalArray.length]; // Increase the size by multiple of 2
            /* Copy the full Array to the new Array
             and because it is circular, we have to copy front to the newArray then copy the Circular back items
             to maintain the order of insertion
             */
            // Copy all front elements
            System.arraycopy(originalArray, front, newArrayStaff, 0, originalArray.length - front);
            // Copy and append all the circular items to the newArray
            System.arraycopy(originalArray, 0, newArrayStaff, originalArray.length - front, back);
            originalArray = newArrayStaff;

            front = 0;
            back = numItem;
        }
        // add new staff to the back of the stack
        originalArray[back] = newStaff; // <<== This op is O(1) if resizing isn't required
        if (back < originalArray.length - 1)
            back++;
        else
            back = 0; // Circle back to Empty space in front of the queue
    }// End push

    public Staff remove()
    {
        // Since Queue operates FIFO, the elements in the queue are removed from the front
        Staff poppedStaff = null;
        if (!isEmpty())
        {
            poppedStaff = originalArray[front];
            //
            originalArray[front] = null;
            // Check if array has been expanded
                front++;
            if (size() == 0)
            {
                front = 0;
                back = 0;
            }
            else if (front == originalArray.length)
            {
                front = 0; // circle back to empty space in front
            }
            return poppedStaff;
        }
        else
            throw new EmptyStackException();
    }

    public Staff peek()
    {
        // Returns Item in front of the queue without removing it
        if (isEmpty())
            throw new EmptyStackException();
        return originalArray[front];
    }

    public void printStack()
    {
        // Start from the front to bottom
        if (front <= back) {
            for (int i = front; i < back; i++)
                System.out.println(originalArray[i]);
        }
        else
        {
            // Print front of the queue
            for (int i = front; i < originalArray.length; i++)
                System.out.println(originalArray[i]);
            // Print back of the  Circular Queue
            for (int i = 0; i < back; i++)
                System.out.println(originalArray[i]);
        }
    }



}//End ArrayBacked_Stack_Impl
