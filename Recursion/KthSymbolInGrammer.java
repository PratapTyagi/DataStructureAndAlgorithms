public class KthSymbolInGrammer {
    static int solve(int n, int k) {
        if (n == 1 && k == 1)
            return 0;

        int mid = (int) Math.pow(2, n - 1) / 2;
        if (k <= mid)
            return solve(n - 1, k);
        else
            return solve(n - 1, k - mid) == 1 ? 0 : 1;
    }

    public static void main(String[] args) {
        int N = 4, K = 3;

        System.out.println(solve(N, K));
    }
}
