import java.util.ArrayDeque;

public class LISImplementation {
    static class Pair {
        int l;
        int i;
        int v;
        String psf;

        public Pair(int l, int i, int v, String p) {
            this.l = l;
            this.i = i;
            this.v = v;
            psf = p;
        }
    }

    static int longestSubsequence(int size, int arr[]) {
        int[] dp = new int[size];
        int overAllMax = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    max = Math.max(max, dp[j]);

            dp[i] = max + 1;
            overAllMax = Math.max(overAllMax, dp[i]);
        }

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();

        for (int i = 0; i < dp.length; i++)
            if (dp[i] == overAllMax)
                queue.addLast(new Pair(dp[i], i, arr[i], arr[i] + ""));

        while (!queue.isEmpty()) {
            Pair peek = queue.removeFirst();

            if (peek.l == 1)
                System.out.println(peek.psf);

            for (int i = 0; i < peek.i; i++)
                if (dp[i] == peek.l - 1 && arr[i] <= peek.v)
                    queue.addLast(new Pair(dp[i], i, arr[i], arr[i] + " " + peek.psf));
        }

        return overAllMax;
    }

    public static void main(String[] args) {
        int A[] = { 10, 22, 43, 33, 21, 50, 41, 60, 59, 3 };

        System.out.println(longestSubsequence(A.length, A));
    }

}