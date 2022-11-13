public class JosephusProblemBits {
    static int maxPowOf2(int n) {
        int i = 1;

        while (i * 2 <= n)
            i = i * 2;

        return i;
    }

    public static void main(String[] args) {
        int n = 17;

        int max = maxPowOf2(n);
        int l = n - max;
        int ans = 2 * l + 1;

        System.out.println(ans);
    }
}
