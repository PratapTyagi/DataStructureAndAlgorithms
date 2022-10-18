import java.util.ArrayList;
import java.util.PriorityQueue;

public class IIINearlySorted {
    static ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        int n = arr.length;
        if (k >= n) {
            ArrayList<Integer> al = new ArrayList<Integer>();
            for (int i : arr)
                al.add(i);
            return al;
        }

        ArrayList<Integer> al = new ArrayList<Integer>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(arr[i]);

            if (q.size() == k + 1)
                al.add(q.remove());
        }

        while (!q.isEmpty())
            al.add(q.remove());

        return al;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        ArrayList<Integer> ans = nearlySorted(arr, arr.length, 3);
        for (Integer i : ans)
            System.out.print(i + " ");
    }
}
