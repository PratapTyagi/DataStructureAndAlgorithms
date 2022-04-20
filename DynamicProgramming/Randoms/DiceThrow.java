import java.util.HashMap;

class DiceThrow {
    static long solve(int m, int n, int x, HashMap<String, Long> map) {
        if (n == 0 && x == 0)
            return 1;
        if (n == 0)
            return 0;

        if (map.containsKey(n + "," + x))
            return map.get(n + "," + x);

        long res = 0;
        for (int i = 1; i <= m && x >= i; i++)
            res += solve(m, n - 1, x - i, map);
        map.put(n + "," + x, res);
        return res;
    }

    static long noOfWays(int m, int n, int x) {
        HashMap<String, Long> map = new HashMap<>();
        return solve(m, n, x, map);
    }

    public static void main(String[] args) {
        int M = 6, N = 3, X = 12;
        System.out.println(noOfWays(M, N, X));
    }
}