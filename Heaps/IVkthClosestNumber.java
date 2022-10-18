import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IVkthClosestNumber {
    static class Pair {
        int diff;
        int value;

        Pair(int diff, int value) {
            this.diff = diff;
            this.value = value;
        }
    }

    static class ValueBasedSort implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.value < b.value)
                return -1;
            else if (a.value > b.value)
                return 1;
            else
                return 0;
        }
    }

    static class DiffBasedSort implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.diff < b.diff)
                return 1;
            else if (a.diff > b.diff)
                return -1;
            else
                return new ValueBasedSort().compare(a, b);
        }
    }

    static ArrayList<Integer> solve(int[] arr, int n, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new DiffBasedSort());

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(arr[i] - k);
            if (diff == 0)
                continue;

            q.add(new Pair(diff, arr[i]));
            if (q.size() > k)
                q.remove();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty())
            ans.add(0, q.remove().value);

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        ArrayList<Integer> ans = solve(arr, arr.length, 3);
        for (Integer e : ans)
            System.out.print(e + " ");
    }
}
