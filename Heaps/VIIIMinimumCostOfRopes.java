import java.util.PriorityQueue;

public class VIIIMinimumCostOfRopes {
    static long minCost(long arr[], int n) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (long i : arr)
            q.add(i);

        long cost = 0;
        while (q.size() >= 2) {
            long first = q.remove();
            long second = q.remove();

            cost += first + second;
            q.add(first + second);
        }

        return cost;
    }

    public static void main(String[] args) {
        int n = 4;
        long arr[] = { 4, 3, 2, 6 };
        System.out.println(minCost(arr, n));
    }
}
