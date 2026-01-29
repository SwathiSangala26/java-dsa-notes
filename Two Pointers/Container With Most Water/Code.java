public class Main {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] heights = {1, 7, 2, 5, 4, 7, 3, 6};

        int result = sol.maxArea(heights);

        System.out.println("Maximum area: " + result);
    }
}

public class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}

Time & Space Complexity
• Time complexity: O(n)
• Space complexity: 0(1)
