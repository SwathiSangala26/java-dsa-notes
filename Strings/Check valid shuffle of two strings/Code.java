public class ValidShuffle {
    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "def";
        String s3 = "adbcef";

        if (s1.length() + s2.length() != s3.length()) {
            System.out.println(false);
            return;
        }

        int i = 0, j = 0;

        for (int k = 0; k < s3.length(); k++) {
            if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
                i++;
            } else if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
                j++;
            } else {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
    }
}
