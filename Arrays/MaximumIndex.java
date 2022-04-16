public class MaximumIndex {
    static int maxIndexDiff(int arr[], int n) {
        int leftMin[] = new int[n];
        int rightMax[] = new int[n];

        int temp = arr[n - 1];
        int k = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (temp < arr[i]) {
                temp = arr[i];
                rightMax[k] = temp;
            } else
                rightMax[k] = temp;
            k--;
        }

        temp = arr[0];
        k = 0;
        for (int i = 0; i < n; i++) {
            if (temp > arr[i]) {
                temp = arr[i];
                leftMin[k] = temp;
            } else
                leftMin[k] = temp;
            k++;
        }

        int i = 0, j = 0;
        int maxDifference = -1;
        while (i < n && j < n) {
            if (leftMin[i] <= rightMax[j]) {
                int diff = j - i;
                maxDifference = Math.max(maxDifference, diff);
                j++;
            } else
                i++;
        }
        return maxDifference;
    }

    public static void main(String[] args) {
        int arr[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        System.out.println(maxIndexDiff(arr, arr.length));
    }
}
