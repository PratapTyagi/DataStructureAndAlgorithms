import java.util.HashMap;

public class SubarraysWithEqual1s0s {
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                sum -= 1;
            else
                sum += 1;

            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else
                map.put(sum, 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 0, 1, 0, 1, 1 };
        int n = arr.length;
        System.out.println(countSubarrWithEqualZeroAndOne(arr, n));
    }
}
