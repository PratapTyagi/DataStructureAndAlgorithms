public class AllocateMinNoOfPages {

    private static boolean isValid(int[] arr, int n, int maxStudents, int mid) {
        int students = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > mid) {
                students++;
                sum = arr[i];
            }
            if (students > maxStudents)
                return false;
        }
        return true;
    }

    private static int[] maxSumAndEle(int[] arr, int n) {
        int maxEle = -1;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += arr[i];
            maxEle = Math.max(maxEle, arr[i]);
        }

        return new int[] { maxEle, maxSum };
    }

    private static int find(int[] arr, int n, int maxStudents) {
        int maxSumAndEle[] = maxSumAndEle(arr, n);
        int low = maxSumAndEle[0];
        int high = maxSumAndEle[1];
        int res = -1;

        if (maxStudents > high)
            return res;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, n, maxStudents, mid)) {
                res = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40 };
        int maxStudents = 2;

        // minimize max no. of pages
        System.out.println(find(arr, arr.length, maxStudents));
    }
}
