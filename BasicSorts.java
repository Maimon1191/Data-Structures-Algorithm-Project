import java.util.Arrays;

/**
 * This class provides implementations of various sorting algorithms.
 */
public class BasicSorts {

    public static void main(String[] args) {
        int[] myArray = {4, 2, 6, 5, 1, 3};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    /**
     * Sorts an array using the bubble sort algorithm.
     * @param arr the array to be sorted.
     */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array using the selection sort algorithm.
     * @param arr the array to be sorted.
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Sorts an array using the insertion sort algorithm.
     * @param arr the array to be sorted.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
