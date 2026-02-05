public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

public static void main(String[] args) {
    Solution sol = new Solution();

    String s1 = "()";
    String s2 = "()[]{}";
    String s3 = "(]";
    String s4 = "({[]})";
    String s5 = "(((";

    System.out.println(s1 + " → " + sol.isValid(s1)); // true
    System.out.println(s2 + " → " + sol.isValid(s2)); // true
    System.out.println(s3 + " → " + sol.isValid(s3)); // false
    System.out.println(s4 + " → " + sol.isValid(s4)); // true
    System.out.println(s5 + " → " + sol.isValid(s5)); // false
}

Time & Space Complexity
• Time complexity: O(n)
• Space complexity: O(n)
