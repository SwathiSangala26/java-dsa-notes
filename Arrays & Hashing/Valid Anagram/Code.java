public class Main {

    public static void main(String[] args) {

        // Create Solution object
        Solution solution = new Solution();

        // Test input
        String s = "anagram";
        String t = "nagaram";

        // Call the method
        boolean result = solution.isAnagram(s, t);

        // Print result
        System.out.println(result); // true
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        // Step 1: If lengths differ, cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Frequency array for 26 lowercase letters
        int[] count = new int[26];

        // Step 3: Count characters
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        // Step 4: Check if all counts are zero
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}

Time & Space Complexity
    • Time complexity: 0(n+ m)
    • Space complexity: O(1) since we have at most 26
    different characters.

Where n is the length of string s and m is the length of string t.
