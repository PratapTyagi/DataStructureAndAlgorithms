import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VIIIMaxGcdOfSiblings {
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int maxBinTreeGCD(List<List<Integer>> arr, int N) {
        if (N == 0 || N == 1 || N == 2)
            return 0;
        Collections.sort(arr, (a, b) -> a.get(0) - b.get(0));

        int maxGcd = 0;
        for (int i = 1; i < N - 1; i++)
            if (arr.get(i - 1).get(0) == arr.get(i).get(0))
                maxGcd = Math.max(maxGcd, gcd(arr.get(i - 1).get(1), arr.get(i).get(1)));

        return maxGcd;
    }

    public static void main(String[] args) {
        int[][] arr = { { 4, 5 }, { 4, 2 }, { 2, 3 }, { 2, 1 }, { 3, 6 }, { 3, 12 } };
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] ints : arr) {
            List<Integer> list = new ArrayList<>();
            for (int i : ints) {
                list.add(i);
            }
            lists.add(list);
        }
        int ans = maxBinTreeGCD(lists, arr.length + 1);
        System.out.println(ans);
    }
}