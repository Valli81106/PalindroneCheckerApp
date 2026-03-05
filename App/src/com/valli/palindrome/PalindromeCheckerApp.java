package com.valli.palindrome;

public class PalindromePerformanceComparison {

    public static void main(String[] args) {

        String original = "A man a plan a canal Panama";
        String normalized = original.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("Input String: " + original);
        System.out.println();

        // Recursive Method
        long start1 = System.nanoTime();
        boolean result1 = recursivePalindrome(normalized, 0, normalized.length() - 1);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // Iterative Two Pointer Method
        long start2 = System.nanoTime();
        boolean result2 = iterativePalindrome(normalized);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // Reverse String Method
        long start3 = System.nanoTime();
        boolean result3 = reversePalindrome(normalized);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        // Display Results
        System.out.println("Recursive Result: " + result1 + " | Time: " + time1 + " ns");
        System.out.println("Iterative Result: " + result2 + " | Time: " + time2 + " ns");
        System.out.println("Reverse Result: " + result3 + " | Time: " + time3 + " ns");
    }

    // Recursive Method
    private static boolean recursivePalindrome(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursivePalindrome(str, start + 1, end - 1);
    }

    // Iterative Two Pointer Method
    private static boolean iterativePalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
    private static boolean reversePalindrome(String str) {

        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}