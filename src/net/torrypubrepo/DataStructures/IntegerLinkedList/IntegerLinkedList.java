package net.torrypubrepo.DataStructures.IntegerLinkedList;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value)
    {
        // Look for Bigger Value than the new Value
        if (isEmpty() || head.getValue() >= value) {
            addToFront(value);
            return;
        }

        IntegerNode currentNode = head.getNext();
        IntegerNode previous = head;
        IntegerNode newNode = new IntegerNode(value);

            while (currentNode != null && currentNode.getValue() <= value)
            {
                previous = currentNode;// Keep track of the previous node
                currentNode = currentNode.getNext();
            };

            if (currentNode == null)
            {
                return;
            }
            else
                {
                    newNode.setNext(currentNode);
                    previous.setNext(newNode);
                }
            size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
