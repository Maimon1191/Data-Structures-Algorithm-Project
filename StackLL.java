/**
 * This class represents a basic stack data structure implemented using a singly linked list.
 */
public class StackLL {

    // Node class to represent elements in the stack
    private Node top;        // points to the top element in the stack
    private int height;      // stores the number of elements in the stack

    // Node class definition
    class Node {
        int value;           // value of the node
        Node next;           // reference to the next node

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Constructor to create a Stack with an initial value.
     * @param value the value to be added to the stack.
     */
    public StackLL(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    /**
     * Get the top node in the stack.
     * @return the top node in the stack.
     */
    public Node getTop() {
        return top;
    }

    /**
     * Get the height (number of elements) of the stack.
     * @return the number of elements in the stack.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Print the elements of the stack.
     */
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Print information about the stack including the top element and height.
     */
    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height: " + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    /**
     * Make the stack empty by resetting the top and height.
     */
    public void makeEmpty() {
        top = null;
        height = 0;
    }

    /**
     * Push an element onto the top of the stack.
     * @param value the value to be added to the stack.
     */
    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    /**
     * Pop and return the top element from the stack.
     * @return the top element of the stack, or null if the stack is empty.
     */
    public Node pop (){
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
}
