import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class VTopKFrequentElements {
    private static class Pair {
        int freq;
        int value;

        Pair(int f, int v) {
            freq = f;
            value = v;
        }
    }

    private static class FreqSort implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.freq == b.freq ? a.value - b.value : a.freq - b.freq;
        }
    }

    public static ArrayList<Integer> topK(int[] nums, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new FreqSort());
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            q.add(new Pair(e.getValue(), e.getKey()));

            if (q.size() > k)
                q.remove();
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty())
            res.add(0, q.remove().value);

        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 1, 2, 2, 3 };
        ArrayList<Integer> ans = topK(arr, 2);
        for (Integer e : ans)
            System.out.print(e + " ");
    }
}
