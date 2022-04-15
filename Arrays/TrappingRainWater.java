public class TrappingRainWater {
    static long trappingWater(int arr[], int n) {
        if (n <= 2)
            return 0;
        int left = 1, right = n - 1;
        int leftMax = arr[0], rightMax = arr[n - 1];
        long trappedWater = 0;

        while (left <= right) {
            if (leftMax <= rightMax) {
                if (arr[left] > leftMax)
                    leftMax = arr[left];
                else
                    trappedWater += leftMax - arr[left];
                left++;
            } else {
                if (arr[right] > rightMax)
                    rightMax = arr[right];
                else
                    trappedWater += rightMax - arr[right];
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 4, 0, 9 };
        System.out.println(trappingWater(arr, arr.length));
    }
}
