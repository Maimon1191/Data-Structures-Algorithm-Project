/**
 * This class represents a simple queue data structure implemented using a singly linked list.
 */
public class Queue {

    // Node class to represent elements in the queue
    private Node first;  // points to the first element in the queue
    private Node last;   // points to the last element in the queue
    private int length;  // stores the number of elements in the queue

    // Node class definition
    class Node {
        int value;  // value of the node
        Node next;  // reference to the next node

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor to create a Queue with an initial value.
     * @param value the value to be added to the queue.
     */
    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    /**
     * Get the first node in the queue.
     * @return the first node in the queue.
     */
    public Node getFirst() {
        return first;
    }

    /**
     * Get the last node in the queue.
     * @return the last node in the queue.
     */
    public Node getLast() {
        return last;
    }

    /**
     * Get the length of the queue.
     * @return the number of elements in the queue.
     */
    public int getLength() {
        return length;
    }

    /**
     * Print the elements of the queue.
     */
    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Print information about the queue including first, last, and length.
     */
    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Make the queue empty by resetting the first, last, and length.
     */
    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    /**
     * Add an element to the end of the queue.
     * @param value the value to be added to the queue.
     */
    public void enqueue(int value){
        Node newNode = new Node(value);
        if (length == 0){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
}
