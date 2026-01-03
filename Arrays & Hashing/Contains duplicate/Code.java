import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        
        for(int num : nums)
        {
            if(!set.add(num))
                return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 3};
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);
    }
}
