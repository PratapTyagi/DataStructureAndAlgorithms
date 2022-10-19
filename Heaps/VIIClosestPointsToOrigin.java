import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class VIIClosestPointsToOrigin {
    private static class Pair {
        double dist;
        int x;
        int y;

        Pair(double d, int i, int j) {
            dist = d;
            x = i;
            y = j;
        }
    }

    private static class DistanceSort implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return (int) (b.dist - a.dist);
        }
    }

    private static double maxDistance(int x, int y) {
        return Math.pow(x, 2) + Math.pow(y, 2);
    }

    private static ArrayList<int[]> solve(int[][] points, int k) {
        int n = points.length;

        PriorityQueue<Pair> q = new PriorityQueue<>(new DistanceSort());
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            double distance = maxDistance(point[0], point[1]);
            q.add(new Pair(distance, point[0], point[1]));

            if (q.size() > k)
                q.remove();
        }

        ArrayList<int[]> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            Pair top = q.remove();
            ans.add(new int[] { top.x, top.y });
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int K = 2;
        ArrayList<int[]> ans = solve(points, K);

        for (int[] ele : ans)
            System.out.println(ele[0] + " " + ele[1]);
    }
}