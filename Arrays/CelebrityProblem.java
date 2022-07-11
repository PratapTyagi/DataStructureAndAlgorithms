public class CelebrityProblem {
    static int celebrity(int m[][], int n) {
        int c = 0;
        for (int i = 1; i < n; i++)
            if (m[c][i] == 1)
                c = i;

        for (int i = 0; i < n; i++) {
            if (i != c && (m[i][c] == 0 || m[c][i] == 1))
                return -1;
        }

        return c;
    }

    public static void main(String[] args) {
        int N = 3, M[][] = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        System.out.println(celebrity(M, N));
    }
}
