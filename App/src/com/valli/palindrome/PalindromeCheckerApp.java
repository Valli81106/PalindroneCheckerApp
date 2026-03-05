package com.valli.palindrome;

public class PalindromeCheckerApp {

    public static void main(String[] args){

        String original = "Ra dar";
        String normalized = original.toLowerCase().replaceAll("\\s+", "");
        boolean isPalindrome = checkPalindrome(normalized, 0, normalized.length() - 1);
        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
    private static boolean checkPalindrome(String str, int start,int end) {

        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return checkPalindrome(str, start + 1, end - 1);
    }
}