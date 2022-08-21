import java.util.ArrayDeque;

public class RottenOranges {
    private static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int rows = grid.length;
        int columns = grid[0].length;
        int count_oranges = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j });
                if (grid[i][j] != 0)
                    count_oranges++;
            }
        }

        int rotten_count = 0, time_taken = 0;
        int[] dx = new int[] { 0, 0, -1, 1 };
        int[] dy = new int[] { -1, 1, 0, 0 };
        while (!q.isEmpty()) {
            int size = q.size();
            rotten_count += size;

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x < 0 || y < 0 || x >= rows || y >= columns || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    q.add(new int[] { x, y });
                }
            }

            if (!q.isEmpty())
                time_taken++;
        }

        return rotten_count == count_oranges ? time_taken : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 2, 0, 1 } };
        int ans = orangesRotting(grid);
        System.out.println(ans);
    }
}
