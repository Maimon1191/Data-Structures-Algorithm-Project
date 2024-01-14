import java.util.HashMap;
import java.util.*;

public class Main {

    public static String reverseString(String str){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i ++){
            stack.push(str.charAt(i));
        }

        String reversedString = "";

        while (!stack.isEmpty()){
            reversedString += stack.pop();
        }

        return reversedString;
    }

    public static boolean isBalancedParentheses(String str){
        // Good ques for interview
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']') {

                if (stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void sortStack(Stack<Integer> s){
        Stack<Integer> additionalStack = new Stack<>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!additionalStack.isEmpty() && temp < additionalStack.peek()) {
                s.push(additionalStack.pop());
            }
            additionalStack.push(temp);
        }
        while (!additionalStack.isEmpty()) {
            s.push(additionalStack.pop());
        }
    }



    public static void main(String[] args) {
        Heap myHeap = new Heap();
        myHeap.insert(99);
        myHeap.insert(72);
        myHeap.insert(58);
        myHeap.insert(61);
        myHeap.insert(100);
        System.out.println(myHeap.getHeap());



    }


}