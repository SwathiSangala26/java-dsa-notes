import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1️⃣ Create Solution object
        Solution solution = new Solution();

        // 2️⃣ Input array
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};

        // 3️⃣ Call the method
        List<List<String>> result = solution.groupAnagrams(strs);

        // 4️⃣ Print the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }
}
