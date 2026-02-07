public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}

public class Main {
    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6, 1, 2};

        Solution sol = new Solution();   // create object
        int min = sol.findMin(nums);     // call method

        System.out.println("Minimum element: " + min);
    }
}

Time & Space Complexity
• Time complexity: O(log n)
• Space complexity: O(1)
