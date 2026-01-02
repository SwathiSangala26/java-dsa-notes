class ReverseString {
    public static void main(String[] args) {
        String str = "abcde";

        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(new String(arr));
    }
}
