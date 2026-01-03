import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // 1️⃣ Create Solution object
        Solution solution = new Solution();

        // 2️⃣ Input array and target
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 3️⃣ Call the twoSum method
        int[] result = solution.twoSum(nums, target);

        // 4️⃣ Print the result
        System.out.println(result[0] + " " + result[1]);
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i);
        }

        return new int[] {};
    }
}
