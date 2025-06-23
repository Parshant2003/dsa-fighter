public class ValidParenthises {

    // Recursive function to check validity
    public static boolean solve(String s, int index, int open) {
        // If open becomes negative, invalid state
        if (open < 0)
            return false;

        // If we reached the end of the string
        if (index == s.length()) {
            return open == 0; // valid only if all opens are closed
        }

        char ch = s.charAt(index);
        boolean isValid = false;

        if (ch == '(') {
            isValid = solve(s, index + 1, open + 1);
        } else if (ch == ')') {
            isValid = solve(s, index + 1, open - 1);
        } else if (ch == '*') {
            // Try all 3 possibilities
            boolean asOpen = solve(s, index + 1, open + 1); // '*' as '('
            boolean asClose = solve(s, index + 1, open - 1); // '*' as ')'
            boolean asEmpty = solve(s, index + 1, open); // '*' as empty
            isValid = asOpen || asClose || asEmpty;
        }

        return isValid;
    }

    public static boolean checkValidString(String s) {
        return solve(s, 0, 0);
    }

    public static void main(String[] args) {
        String s = "(*))";
        boolean result = checkValidString(s);

        if (result) {
            System.out.println("✅ Valid Parentheses String");
        } else {
            System.out.println("❌ Invalid Parentheses String");
        }
    }
}
