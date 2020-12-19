package net.torrypubrepo.DataStructures.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args)
    {
        // Challenge ==>> Remove Duplicate from the LinkedList<Employee>

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        System.out.println(" ============== List with Duplicate Entries ==============");
        employees.forEach(System.out::println);
        System.out.println("----------------------------------------------");

        // Create HashMap to store employee using employee Id
        HashMap<Integer, Employee> employeeTable = new HashMap<>();

        ListIterator<Employee> iterator = employees.listIterator();
        // Temp to add duplicate employee
        List<Employee> remove = new ArrayList<>();

        while (iterator.hasNext())
        {
            Employee employee = iterator.next();
            if (employeeTable.containsKey(employee.getId()))
            {
                remove.add(employee);
            }
            else {
                employeeTable.put(employee.getId(), employee);
            }
        }

        // Remove Duplicate from the LinkedList
        for (Employee employee: remove)
        {
            employees.remove(employee);
        }

        System.out.println(" ============== List without Duplicate Entries ==============");
        employees.forEach(System.out::println);
        System.out.println("-------------------------");



//        int[] nums = new int[10];
//        int[] numsToAdd = { 59382, 43, 6894, 500, 99, -58 };
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
