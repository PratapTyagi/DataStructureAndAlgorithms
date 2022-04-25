public class SkipWork {
    static int minAmount(int arr[], int n) {
        if (n <= 1)
            return 0;
        if (n == 2)
            return Math.min(arr[0], arr[1]);

        for (int i = n - 3; i >= 0; i--)
            arr[i] = arr[i] + Math.min(arr[i + 1], arr[i + 2]);

        return Math.min(arr[0], arr[1]);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 7, 10 };
        System.out.println(minAmount(arr, arr.length));
    }
}
