import java.util.ArrayList;

/**
 * This class represents a basic hash table data structure.
 */
public class HashTable {
    private int size = 7;      // Initial size of the hash table
    private Node[] dataMap;    // Array to store key-value pairs

    // Node class to represent key-value pairs
    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Constructor to create a hash table with an initial size.
     */
    public HashTable() {
        dataMap = new Node[size];
    }

    /**
     * Get the underlying data map (array) of the hash table.
     * @return the array containing the key-value pairs.
     */
    public Node[] getDataMap() {
        return dataMap;
    }

    /**
     * Print the contents of the hash table.
     */
    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    /**
     * Hash a given key to determine its index in the data map.
     * @param key the key to be hashed.
     * @return the index in the data map where the key-value pair should be stored.
     */
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    /**
     * Set a key-value pair in the hash table.
     * @param key the key to be added or updated.
     * @param value the value associated with the key.
     */
    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            if (temp.key.equals(key)) {
                temp.value += value;
                return;
            }
            while (temp.next != null) {
                temp = temp.next;
                if (temp.key.equals(key)) {
                    temp.value += value;
                    return;
                }
            }
            temp.next = newNode;
        }
    }

    /**
     * Get the value associated with a given key in the hash table.
     * @param key the key for which to retrieve the value.
     * @return the value associated with the key, or 0 if the key is not found.
     */
    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    /**
     * Get all keys stored in the hash table.
     * @return an ArrayList containing all the keys in the hash table.
     */
    public ArrayList<String> keys(){
        ArrayList<String> allKeys = new ArrayList<String>();
        for (int i = 0; i < dataMap.length; i ++){
            Node temp = dataMap[i];
            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
