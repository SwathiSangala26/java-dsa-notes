public class Main {
    public static void main(String[] args) {
        // Input array
        int[] nums = {1, 2, 4, 6};

        // Create Solution object
        Solution sol = new Solution();

        // Call the method
        int[] result = sol.productExceptSelf(nums);

        // Print the result
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}
