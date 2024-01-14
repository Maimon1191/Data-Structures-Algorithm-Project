/**
 * This class represents a singly linked list data structure.
 */
public class LinkedList {

    // Node class to represent elements in the linked list
    private Node head;   // points to the first element in the list
    private Node tail;   // points to the last element in the list
    private int length;  // stores the number of elements in the list

    // Node class definition
    class Node {
        int value;       // value of the node
        Node next;      // reference to the next node

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor to create a LinkedList with an initial value.
     * @param value the value to be added to the list.
     */
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    /**
     * Get the head (first node) of the linked list.
     * @return the head node of the linked list.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Get the tail (last node) of the linked list.
     * @return the tail node of the linked list.
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Get the length of the linked list.
     * @return the number of elements in the linked list.
     */
    public int getLength() {
        return length;
    }

    /**
     * Print the elements of the linked list.
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Print information about the linked list including head, tail, and length.
     */
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    /**
     * Make the linked list empty by resetting the head, tail, and length.
     */
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * Append an element to the end of the linked list.
     * @param value the value to be added to the end of the linked list.
     */
    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Remove and return the last node from the linked list.
     * @return the last node of the linked list, or null if the list is empty.
     */
    public Node removeLast(){
        Node temp = head;
        Node pre = head;

        if (length == 0) return null;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * Prepend an element to the beginning of the linked list.
     * @param value the value to be added to the beginning of the linked list.
     */
    public void prepend(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    /**
     * Remove and return the first node from the linked list.
     * @return the first node of the linked list, or null if the list is empty.
     */
    public Node removeFirst(){
        Node temp = head;
        if (length == 0) return null;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    /**
     * Get the node at a specific index in the linked list.
     * @param index the index of the node to retrieve.
     * @return the node at the specified index, or null if the index is out of bounds.
     */
    public Node get(int index){
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i ++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Set the value of the node at a specific index in the linked list.
     * @param index the index of the node to set.
     * @param value the new value to set.
     * @return true if the node at the specified index was successfully updated, false otherwise.
     */
    public boolean set(int index, int value){
        Node temp = get(index);
        if (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    /**
     * Insert an element at a specific index in the linked list.
     * @param index the index at which to insert the element.
     * @param value the value to insert.
     * @return true if the element was successfully inserted, false if the index is out of bounds.
     */
    public boolean insert(int index, int value){
        if (index < 0 || index > length) return false;
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    /**
     * Remove and return the node at a specific index in the linked list.
     * @param index the index of the node to remove.
     * @return the removed node, or null if the index is out of bounds.
     */
    public Node remove(int index){
        if (index < 0 || index >= length) return null;
        if (index == length - 1 ) return removeLast();
        if (index == 0 ) return removeFirst();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    /**
     * Reverse the linked list in place.
     */
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for(int i = 0; i < length; i ++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}
