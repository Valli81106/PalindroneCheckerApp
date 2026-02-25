import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args){

        String original = "level";

        // Convert string to linked list
        Node head = stringToLinkedList(original);

        // Check if palindrome
        boolean isPalindrome = isPalindrome(head);

        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
    // Convert string to singly linked list
    private static Node stringToLinkedList(String s) {
        if (s.length() == 0) return null;

        Node head = new Node(s.charAt(0));
        Node current = head;

        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }

        return head;
    }
    // Check if linked list is palindrome
    private static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using fast & slow pointers
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverseList(slow.next);

        // Step 3: Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalfCopy = secondHalf; // to restore later if needed

        boolean palindrome = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return palindrome;
    }

    // ReversING
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}