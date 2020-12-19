package net.torrypubrepo.DataStructures.HashTable;

import net.torrypubrepo.Staff;

public class Client {

    public static void main(String[] args)
    {
        // Create Sample Staff Objects
        Staff conner = new Staff("Conner","Mario",123);
        Staff john = new Staff("John", "McCanny", 1029);
        Staff billy = new Staff("Billy", "Jones", 4537);
        Staff jane = new Staff("Jane", "Doe", 8745);

        System.out.println("============ Basic HashTable Implementation ==============");
        // Add to Basic HashTable
        BasicHashTable_Impl table = new BasicHashTable_Impl();

        // Hash Table with Linear Probing

        table.put("Conner", conner);
        table.put("John", john);
        table.put("Billy", billy);
        table.put("Jane", jane);

        // Print
        table.printHashTable();

        System.out.println("============ End Of Basic HashTable Implementation ==============");

        System.out.println();

        // Hash Table with Linear Probing
        System.out.println("============ Linear Probing Implementation ==============");
        LinearProbing_HashTable_Impl linearProbingHashTable = new LinearProbing_HashTable_Impl();

        linearProbingHashTable.put("Conner", conner);
        linearProbingHashTable.put("John", john);
        linearProbingHashTable.put("Billy", billy);
        linearProbingHashTable.put("Jane", jane);

        // Print
        linearProbingHashTable.printHashTable();

        // Remove
        System.out.println(" Get Item with Key Jane : "+linearProbingHashTable.remove("John"));
        // Get
        System.out.println(" Get Item with Key Jane : "+linearProbingHashTable.get("Jane"));

        System.out.println();

        // Print
        linearProbingHashTable.printHashTable();

        System.out.println("============ End Of Linear Probing Implementation ==============");

    }//End main
}
