import java.util.ArrayList;

public class SpirallyTraversingMatrix {
    static ArrayList<Integer> spirallyTraverse(int arr[][], int r, int c) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int left = 0, right = arr[0].length - 1;
        int top = 0, bottom = arr.length - 1;

        while (true) {
            if (left > right)
                break;

            for (int i = left; i <= right; i++)
                res.add(arr[top][i]);
            top++;

            if (top > bottom)
                break;

            for (int i = top; i <= bottom; i++)
                res.add(arr[i][right]);
            right--;

            if (left > right)
                break;

            for (int i = right; i >= left; i--)
                res.add(arr[bottom][i]);
            bottom--;

            if (top > bottom)
                break;

            for (int i = bottom; i >= top; i--)
                res.add(arr[i][left]);
            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        ArrayList<Integer> al = spirallyTraverse(matrix, matrix.length, matrix[0].length);

        for (int i : al)
            System.out.print(i + " ");
    }
}
