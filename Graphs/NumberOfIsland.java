public class NumberOfIsland {
    static void fillVisited(int[][] arr, boolean[][] isVisited, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 1 || isVisited[i][j])
            return;

        isVisited[i][j] = true;
        fillVisited(arr, isVisited, i + 1, j);
        fillVisited(arr, isVisited, i - 1, j);
        fillVisited(arr, isVisited, i, j + 1);
        fillVisited(arr, isVisited, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 0, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 0, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1, 1, 0 },
        };

        int count = 0;
        boolean[][] isVisited = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0 && !isVisited[i][j]) {
                    fillVisited(arr, isVisited, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
