import java.util.Arrays;


public class ArraysEx {

    public static int removeElement(int[] nums, int val){
        if (nums.length == 0) return 0;
        int index = 0; // Initialize an index to keep track of the valid elements.

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i]; // Shift the valid element to the front.
                index++;
            }
        }

        return index; // Return the new length of the modified array.
    }

    public static int[] findMaxMin(int[] myList){
        int tempMin = myList[0];
        int tempMax = myList[0];
        for (int num : myList){
            if (num > tempMax){
                tempMax = num;
            }
            else if (num < tempMin) {
                tempMin = num;
            }
        }
        return new int[]{tempMax,tempMin};
    }

    public static int maxSubarray(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1 ) return nums[0];
        int maxSub = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = nums[i] + nums[j];
                if (temp > maxSub) {
                    maxSub = temp;

                }
            }
        }
        return maxSub;
    }




    public static void main(String[] args) {
        // Example 1: Simple case with positive and negative numbers
        int[] inputCase1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = maxSubarray(inputCase1);
        System.out.println("Example 1: Input: " + Arrays.toString(inputCase1) + "\nResult: " + result1);

        // Example 2: Case with a negative number in the middle
        int[] inputCase2 = {1, 2, 3, -4, 5, 6};
        int result2 = maxSubarray(inputCase2);
        System.out.println("Example 2: Input: " + Arrays.toString(inputCase2) + "\nResult: " + result2);

        // Example 3: Case with all negative numbers
        int[] inputCase3 = {-1, -2, -3, -4, -5};
        int result3 = maxSubarray(inputCase3);
        System.out.println("Example 3: Input: " + Arrays.toString(inputCase3) + "\nResult: " + result3);

        // Example 4: Case with all positive numbers
        int[] inputCase4 = {1, 2, 3, 4, 5};
        int result4 = maxSubarray(inputCase4);
        System.out.println("Example 4: Input: " + Arrays.toString(inputCase4) + "\nResult: " + result4);

        // Example 5: Case with alternating positive and negative numbers
        int[] inputCase5 = {1, -1, 1, -1, 1};
        int result5 = maxSubarray(inputCase5);
        System.out.println("Example 5: Input: " + Arrays.toString(inputCase5) + "\nResult: " + result5);

        /*
            EXPECTED OUTPUT:
            ----------------
            Example 1: Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
            Result: 6
            Example 2: Input: [1, 2, 3, -4, 5, 6]
            Result: 13
            Example 3: Input: [-1, -2, -3, -4, -5]
            Result: -1
            Example 4: Input: [1, 2, 3, 4, 5]
            Result: 15
            Example 5: Input: [1, -1, 1, -1, 1]
            Result: 1
        */

    }



}
