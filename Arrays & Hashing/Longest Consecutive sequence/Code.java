import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Method given in the problem
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    // 👇 Calling function (main method)
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {2, 20, 4, 10, 3, 4, 5};
        int[] nums2 = {0, 3, 2, 5, 4, 6, 1, 1};

        int result1 = sol.longestConsecutive(nums1);
        int result2 = sol.longestConsecutive(nums2);

        System.out.println("Longest consecutive length (Example 1): " + result1);
        System.out.println("Longest consecutive length (Example 2): " + result2);
    }
}

Time & Space Complexity
  • Time complexity: On)
  • Space complexity: On)
