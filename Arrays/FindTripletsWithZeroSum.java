import java.util.Arrays;

public class FindTripletsWithZeroSum {
    static boolean findTriplets(int arr[], int n) {
        if (n < 3)
            return false;

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            while (low < high) {
                if (arr[i] + arr[low] + arr[high] < 0)
                    low++;
                else if (arr[i] + arr[low] + arr[high] > 0)
                    high--;
                else
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 5, arr[] = { 0, -1, 2, -3, 1 };
        System.out.println(findTriplets(arr, n));
    }
}
