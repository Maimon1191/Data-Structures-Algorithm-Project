/**
 * This class represents a doubly linked list data structure.
 */
public class DoublyLinkedList {

    // Node class to represent elements in the doubly linked list
    private Node head;        // points to the first element in the list
    private Node tail;        // points to the last element in the list
    private int length;       // stores the number of elements in the list

    // Node class definition
    class Node {
        int value;           // value of the node
        Node next;           // reference to the next node
        Node prev;           // reference to the previous node

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor to create a DoublyLinkedList with an initial value.
     * @param value the value to be added as the first element of the list.
     */
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Get the head (first node) of the doubly linked list.
     * @return the head node of the list.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Get the tail (last node) of the doubly linked list.
     * @return the tail node of the list.
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Get the length (number of elements) of the doubly linked list.
     * @return the number of elements in the list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Print the elements of the doubly linked list.
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Print information about the doubly linked list including head, tail, and length.
     */
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Append an element to the end of the doubly linked list.
     * @param value the value to be added to the end of the list.
     */
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
}
