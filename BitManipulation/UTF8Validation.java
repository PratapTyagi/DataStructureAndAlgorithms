public class UTF8Validation {
    // https://www.geeksforgeeks.org/utf-8-validation-in-java/
    static boolean solve(int[] arr) {
        int remainingBytes = 0;
        for (int val : arr) {
            if (remainingBytes == 0) {
                if (val >> 7 == 0b0) {
                    remainingBytes = 0;
                } else if (val >> 5 == 0b110) {
                    remainingBytes = 1;
                } else if (val >> 4 == 0b1110) {
                    remainingBytes = 2;
                } else if (val >> 3 == 0b11110) {
                    remainingBytes = 3;
                }
            } else {
                if (val >> 6 == 0b10)
                    remainingBytes--;
                else
                    return false;
            }
        }

        if (remainingBytes == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 197, 130, 1 };

        System.out.println(solve(arr));
    }
}
