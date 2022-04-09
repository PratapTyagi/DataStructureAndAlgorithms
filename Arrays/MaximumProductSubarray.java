public class MaximumProductSubarray {
    static long maxProduct(int[] arr, int n) {
        long ans = Integer.MIN_VALUE, prod = 1;

        for (int i : arr) {
            prod *= i;
            ans = Math.max(ans, prod);
            if (i == 0)
                prod = 1;
        }

        prod = 1;

        for (int i = n - 1; i > -1; i--) {
            prod *= arr[i];
            ans = Math.max(ans, prod);
            if (arr[i] == 0)
                prod = 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 6, -3, -10, 0, 2 };
        int n = arr.length;

        System.out.println(maxProduct(arr, n));
    }
}
