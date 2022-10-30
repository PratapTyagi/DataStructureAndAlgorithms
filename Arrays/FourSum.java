import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    static ArrayList<ArrayList<Integer>> solve(int[] arr, int n, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (arr == null || n == 0)
            return res;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target2 = target - arr[i] - arr[j];

                int start = j + 1;
                int end = n - 1;
                while (start < end) {
                    int twoSum = arr[start] + arr[end];

                    if (twoSum < target2)
                        start++;
                    else if (twoSum > target2)
                        end--;
                    else {
                        ArrayList<Integer> tempAns = new ArrayList<>();
                        tempAns.add(arr[i]);
                        tempAns.add(arr[j]);
                        tempAns.add(arr[start]);
                        tempAns.add(arr[end]);

                        res.add(tempAns);
                        while (start < end && arr[start] == tempAns.get(2))
                            start++;
                        while (start < end && arr[end] == tempAns.get(3))
                            end--;
                    }
                }
                while (j + 1 < n && arr[j + 1] == arr[j])
                    j++;
            }
            while (i + 1 < n && arr[i + 1] == arr[i])
                i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3, 3, 4, 4, 4 };
        ArrayList<ArrayList<Integer>> ans = solve(arr, arr.length, 9);

        for (ArrayList<Integer> al : ans) {
            for (Integer ele : al) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
