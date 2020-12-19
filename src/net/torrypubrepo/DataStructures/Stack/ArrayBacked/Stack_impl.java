package net.torrypubrepo.DataStructures.Stack.ArrayBacked;


import net.torrypubrepo.Staff;

public class Stack_impl {

    public static void main(String[] args)
    {
        // Create Sample Staff Objects
        Staff conner = new Staff("Conner","Mario",123);
        Staff john = new Staff("John", "McCanny", 1029);
        Staff billy = new Staff("Billy", "Jones", 4537);
        Staff jane = new Staff("Jane", "Doe", 8745);

        ArrayBacked_Stack_Impl arrayBackedStack = new ArrayBacked_Stack_Impl(10);

        // Stack the Staff
        arrayBackedStack.push(conner);
        arrayBackedStack.push(john);
        arrayBackedStack.push(billy);
        arrayBackedStack.push(jane);

        // Print Stack
        arrayBackedStack.printStack();

        // Peek
        System.out.println(arrayBackedStack.peek());

        // Pop
        System.out.println(arrayBackedStack.pop());

        // Print Stack
        arrayBackedStack.printStack();


    }
}
