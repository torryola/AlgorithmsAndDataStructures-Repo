package net.torrypubrepo.DataStructures.Queue.CircularQueue;


import net.torrypubrepo.Staff;

public class CircularQueue_Client {

    public static void main(String[] args)
    {
        // Create Sample Staff Objects
        Staff conner = new Staff("Conner","Mario",123);
        Staff john = new Staff("John", "McCanny", 1029);
        Staff billy = new Staff("Billy", "Jones", 4537);
        Staff jane = new Staff("Jane", "Doe", 8745);
        Staff jane2 = new Staff("Jane2", "Doe2", 28745);

        Circular_Queue_Impl arrayBackedStack = new Circular_Queue_Impl(4);

        // add the Staff
        arrayBackedStack.add(conner);
        arrayBackedStack.add(john);
        arrayBackedStack.remove();
        arrayBackedStack.add(billy);
        arrayBackedStack.add(jane);
        arrayBackedStack.remove();
        arrayBackedStack.add(jane2);

        // Print Stack
        arrayBackedStack.printStack();

        // Peek
      //  System.out.println(arrayBackedStack.peek());

        // remove
       // System.out.println(arrayBackedStack.remove());

        // Print Stack
        //arrayBackedStack.printStack();


    }
}
