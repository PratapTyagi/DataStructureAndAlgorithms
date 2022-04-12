import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        if (n == 0 || n == 1)
            return n;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int result = 0;
        int platforms = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arr, dep, arr.length));
    }
}
