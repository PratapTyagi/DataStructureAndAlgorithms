public class SumOfXOROfAllPairs {
    static long sumXOR(int arr[], int n) {
        long ans = 0;

        for (int i = 0; i <= 31; i++) {
            long countZero = 0, countOne = 0;
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1L << i)) == 0)
                    countZero++;
                else
                    countOne++;
            }

            long pair = countZero * countOne;
            ans += (1L << i) * pair;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 9 };
        System.out.println(sumXOR(arr, arr.length));
    }
}
