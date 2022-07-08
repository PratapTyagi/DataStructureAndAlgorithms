import java.util.ArrayDeque;

public class CovidSpread {
    static int helpaterp(int[][] arr) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int n = arr.length, m = arr[0].length;
        int ans = 0;

        // Initial infected people
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (arr[i][j] == 2)
                    queue.add(new int[] { i, j, 0 });

        // All posible directions we can move
        int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int a[] = queue.removeFirst();
            ans = a[2];

            for (int b[] : dir) {
                int r = b[0] + a[0];
                int c = b[1] + a[1];

                if (r < 0 || c < 0 || r >= n || c >= m || arr[r][c] != 1)
                    continue;

                // Continue just when value is 1
                arr[r][c] = 2;
                queue.add(new int[] { r, c, a[2] + 1 });
            }
        }

        // If any patient remains uninfected
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (arr[i][j] == 1)
                    return -1;

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };

        System.out.println(helpaterp(arr));
    }
}
