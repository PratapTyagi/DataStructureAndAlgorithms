import java.util.ArrayList;
import java.util.PriorityQueue;

public class IIKthLargestElements {
    static ArrayList<Integer> solve(int[] arr, int n, int k) {
        if (k >= n)
            return new ArrayList<Integer>();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
            if (q.size() == k + 1)
                q.remove();
        }

        ArrayList<Integer> al = new ArrayList<Integer>();
        while (q.size() > 0)
            al.add(0, q.remove());

        return al;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 5, 3, 2, 8, 10, 9 };
        ArrayList<Integer> ans = solve(arr, arr.length, 3);
        for (Integer e : ans)
            System.out.print(e + " ");
    }
}