package net.torrypubrepo.DataStructures.Stack.LinkedListBacked;


import net.torrypubrepo.Staff;

public class LinkedStack_Client {

    public static void main(String[] args)
    {
        // Create Sample Staff Objects
        Staff conner = new Staff("Conner","Mario",123);
        Staff john = new Staff("John", "McCanny", 1029);
        Staff billy = new Staff("Billy", "Jones", 4537);
        Staff jane = new Staff("Jane", "Doe", 8745);

        LinkedStack_Impl arrayBackedStack = new LinkedStack_Impl();

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
