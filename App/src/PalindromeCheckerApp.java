import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args){
        // Original string
        String original = "level";
        Stack<Character> stack = new Stack<>();
        // Push each character into the stack
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }
        // Build reversed string by popping characters
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        // Compare original and reversed
        if (original.equals(reversed)) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
}