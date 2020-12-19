package net.torrypubrepo.DataStructures.Queue;

import net.torrypubrepo.Staff;

import java.util.EmptyStackException;

/*
 Created by Toriola

 The Implementation of Queue backing it with the Array Data Structure
 Ideally, LinkedList is better, array can be used as well if the size of the elements in the Queue is known hence
 no resizing will be required otherwise the time complexity will be affected
 E.g. Resize Capacity means copying the old array into the new expanded array, thus worse case O(n)
 */
public class ArrayBacked_Queue_Impl
{
    // Object to queue
    Staff[] originalArray;
    private int front; // For tacking the size/front of the queue
    private int back;

    public ArrayBacked_Queue_Impl(int capacity)
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
    {
        return back  - front;
    }

    public void add(Staff newStaff)
    {
        // For the queue, object is add from the back, thus back increment wth each addition/insert
        // Check the Size
        if (back == originalArray.length)
        {
            /* Because we have to resize and copy the array elements makes worse case
             Time-Complexity O(n) as the number of steps depends on the size of the array
             */
            // Need to resize the array
            Staff[] newArrayStaff = new Staff[ 2 * originalArray.length]; // Increase the size by multiple of 2
            // Copy the full Array to the new Array
            System.arraycopy(originalArray, 0, newArrayStaff, 0, originalArray.length);
            // Assign the new Array to original
            originalArray = newArrayStaff;
        }
        // add new staff to the back of the stack
        originalArray[back] = newStaff; // <<== This op is O(1) if resizing isn't required
        back++;
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
            front++;
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
        //Arrays.stream(originalArray).forEach(System.out::println);
        for (int i = front; i < back ; i++)
            System.out.println(originalArray[i]);
    }



}//End ArrayBacked_Stack_Impl
