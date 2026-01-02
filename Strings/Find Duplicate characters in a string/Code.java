public class DuplicateCharactersArray {
    public static void main(String[] args) {

        String str = "programming";

        // Step 1: Frequency array for ASCII characters
        int[] freq = new int[256];

        // Step 2: Count each character
        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        // Step 3: Print duplicate characters
        System.out.println("Duplicate characters:");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 1) {
                System.out.println((char) i + " -> " + freq[i]);
            }
        }
    }
}
