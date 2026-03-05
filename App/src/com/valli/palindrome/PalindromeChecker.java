public class PalindromeChecker {

    // Public method exposed to outside
    public boolean checkPalindrome(String original) {

        if (original == null) {
            return false;
        }

        // Normalize inside service class
        String normalized = original
                .toLowerCase()
                .replaceAll("\\s+", "");

        return checkRecursive(normalized, 0, normalized.length() - 1);
    }

    // Private recursive method (Encapsulation)
    private boolean checkRecursive(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return checkRecursive(str, start + 1, end - 1);
    }
}