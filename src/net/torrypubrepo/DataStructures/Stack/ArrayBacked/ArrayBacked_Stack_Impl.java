package net.torrypubrepo.DataStructures.Stack.ArrayBacked;

import net.torrypubrepo.Staff;

import java.util.EmptyStackException;

/*
 Created by Toriola

 The Implementation of Stack backing it with the Array Data Structure
 Ideally, LinkedList is better, array can be used as well if the size of the elements in the stack is known hence
 no resizing will be required otherwise the time complexity will be affected
 E.g. Resize Capacity means copying the old array into the new expanded array, thus worse case O(n)
 */
public class ArrayBacked_Stack_Impl
{
    // Object to stack
    Staff[] originalArray;
    int top; // For tacking the size/top of the stack

    public ArrayBacked_Stack_Impl(int capacity)
    {
        // Initialize the size of Array
        originalArray = new Staff[capacity];
    }

    // Operations
    public boolean isEmpty()
    {
        // Stack is Empty if top is 0
        return top == 0;
    }

    public int size()
    {
        return top;
    }

    public void push(Staff newStaff)
    {
        // Check the Size
        if (top == originalArray.length)
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
        // add new staff to the top of the stack
        originalArray[top++] = newStaff; // <<== This op is O(1) if resizing isn't required
    }// End push

    public Staff pop()
    {
        Staff poppedStaff = null;
        if (!isEmpty())
        {
            poppedStaff = originalArray[--top];
            //
            originalArray[top] = null;
            return poppedStaff;
        }
        else
            throw new EmptyStackException();
    }

    public Staff peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        return originalArray[top - 1];
    }

    public void printStack()
    {
        // Start from the top to bottom
        for (int i = top - 1; i >= 0 ; i--)
            System.out.println(originalArray[i]);
    }



}//End ArrayBacked_Stack_Impl
