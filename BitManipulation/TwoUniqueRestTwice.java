public class TwoUniqueRestTwice {
    static void solve(int n, int[] arr) {
        int totalXor = 0;
        for (int ele : arr)
            totalXor ^= ele;

        // right most set bit mask
        int rmsb = totalXor & -totalXor;

        int x = 0, y = 0;
        for (int val : arr) {
            if ((val & rmsb) == 0) {
                // check if rmsb let's say kth bit is not set
                x = x ^ val;
            } else {
                y = y ^ val;
            }
        }

        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        int N = 5;
        int[] A = { 1, 1, 2, 3, 5, 5 };

        solve(N, A);
    }
}