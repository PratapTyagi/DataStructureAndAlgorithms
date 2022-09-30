public class NextAlphabetticCharacter {
    private static char find(char[] arr, int n, char val) {
        char res = Character.MIN_VALUE;
        if (n == 0)
            return res;
        if (n == 1)
            return res;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparisonValue = Character.compare(arr[mid], val);
            if (comparisonValue > 0) {
                high = mid - 1;
                res = Character.compare(res, arr[mid]) > 0 ? res : arr[mid];
            } else
                low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        char arr[] = { 'A', 'B', 'C', 'D', 'E' };
        System.out.println(find(arr, arr.length, 'C'));
    }
}
