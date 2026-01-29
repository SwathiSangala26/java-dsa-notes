class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;

        while(l<r)
        {
            while(l<r && !alphaNum(s.charAt(l)))
            {
                l++;
            }
            while(r>l && !alphaNum(s.charAt(r)))
            {
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean alphaNum(char ch)
    {
        return (ch >= 'A' && ch <= 'Z') ||
               (ch >= 'a' && ch <= 'z') ||
               (ch >= '0' && ch <= '9');
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(sol.isPalindrome(s1)); // true
        System.out.println(sol.isPalindrome(s2)); // false
    }
}

Time & Space Complexity
• Time complexity: O(n)
• Space complexity: 0(1)
