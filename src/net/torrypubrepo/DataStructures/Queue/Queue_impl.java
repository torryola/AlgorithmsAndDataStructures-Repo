package net.torrypubrepo.DataStructures.Queue;


import net.torrypubrepo.Staff;

public class Queue_impl {

    public static void main(String[] args)
    {
        // Create Sample Staff Objects
        Staff conner = new Staff("Conner","Mario",123);
        Staff john = new Staff("John", "McCanny", 1029);
        Staff billy = new Staff("Billy", "Jones", 4537);
        Staff jane = new Staff("Jane", "Doe", 8745);

        ArrayBacked_Queue_Impl arrayBackedStack = new ArrayBacked_Queue_Impl(10);

        // add the Staff
        arrayBackedStack.add(conner);
        arrayBackedStack.add(john);
        arrayBackedStack.add(billy);
        arrayBackedStack.add(jane);

        // Print Stack
        arrayBackedStack.printStack();

        // Peek
        System.out.println(arrayBackedStack.peek());

        // remove
        System.out.println(arrayBackedStack.remove());

        // Print Stack
        arrayBackedStack.printStack();


    }
}
