class RowWithMax1s {
    static int rowWithMax1s(int arr[][], int n, int m) {
        int maxRow = -1;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (arr[i][j] == 1) {
                maxRow = i;
                j--;
            } else
                i++;
        }
        return maxRow;
    }

    public static void main(String[] args) {
        int arr[][] = { { 0, 0 }, { 1, 1 } };

        System.out.println(rowWithMax1s(arr, arr.length, arr[0].length));
    }

}