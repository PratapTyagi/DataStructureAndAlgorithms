import java.util.*;
import java.io.*;

public class VISortingElementsByFrequency {
    private static class Pair {
        int freq;
        int val;

        Pair(int f, int v) {
            freq = f;
            val = v;
        }
    }

    private static class FreqSort implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.freq == b.freq ? b.val - a.val : a.freq - b.freq;
        }
    }

    private static void solve(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>(new FreqSort());

        for (int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> e : map.entrySet())
            q.add(new Pair(e.getValue(), e.getKey()));

        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair ele = q.remove();
            int freq = ele.freq;
            int val = ele.val;

            while (freq-- > 0)
                ans.add(0, val);
        }

        for (int i : ans)
            System.out.print(i + " ");

        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] ipt = br.readLine().split("\\s+");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(ipt[i]);
            solve(arr, n);
        }
    }
}
