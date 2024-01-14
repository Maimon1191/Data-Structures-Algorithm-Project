import java.util.ArrayList;

/**
 * This class represents a generic stack data structure using an ArrayList.
 * @param <T> the type of elements stored in the stack.
 */
public class Stack<T> {

    // Internal ArrayList to store the elements of the stack
    private ArrayList<T> stackList = new ArrayList<>();

    /**
     * Get the underlying ArrayList of the stack.
     * @return ArrayList containing the stack elements.
     */
    public ArrayList<T> getStackList() {
        return stackList;
    }

    /**
     * Print the elements of the stack in LIFO (Last-In-First-Out) order.
     */
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    /**
     * Check if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    /**
     * Get the element at the top of the stack without removing it.
     * @return the top element of the stack, or null if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    /**
     * Get the number of elements in the stack.
     * @return the number of elements in the stack.
     */
    public int size() {
        return stackList.size();
    }

    /**
     * Push an element onto the top of the stack.
     * @param value the element to be pushed onto the stack.
     */
    public void push(T value) {
        stackList.add(value);
    }

    /**
     * Pop the top element from the stack and remove it.
     * @return the top element of the stack, or null if the stack is empty.
     */
    public T pop (){
        int length = stackList.size();
        if (length == 0) return null;
        T ret = stackList.get(length -1);
        stackList.remove(length -1);
        return ret;
    }
}
