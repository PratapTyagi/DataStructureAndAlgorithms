public class FindMissingAndRepeating {
    static int[] findTwoElement(int arr[], int n) {
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            int curr = Math.abs(arr[i]);
            if (arr[curr - 1] < 0)
                ans[0] = curr;
            else
                arr[curr - 1] = -arr[curr - 1];
        }

        for (int i = 0; i < n; i++)
            if (arr[i] > 0)
                ans[1] = i + 1;

        return ans;
    }

    public static void main(String[] args) {
        int Arr[] = { 1, 3, 3 };

        int[] ans = findTwoElement(Arr, Arr.length);
        for (int i : ans)
            System.out.print(i + " ");
    }
}
