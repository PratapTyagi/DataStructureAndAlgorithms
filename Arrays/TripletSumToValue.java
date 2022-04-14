import java.util.Arrays;

public class TripletSumToValue {
    public static boolean find3Numbers(int arr[], int n, int x) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int l = i + 1, h = n - 1;
            int currSum = x - arr[i];

            while (l < h) {
                if (arr[l] + arr[h] == currSum)
                    return true;
                if (arr[l] + arr[h] > currSum)
                    h--;
                else
                    l++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int X = 17;
        int arr[] = { 1, 4, 45, 6, 10, 8 };

        System.out.println(find3Numbers(arr, arr.length, X));
    }

}