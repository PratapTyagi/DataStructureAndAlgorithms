public class OnesComplement {
    public static void main(String[] args) {
        int num = 5;

        int x, ans = 0;
        for (int i = 0; num > 0; i++) {
            if (num % 2 == 1)
                x = 0;
            else
                x = 1;
            ans += (int) Math.pow(2, i) * x;
            num /= 2;
        }

        System.out.println(ans);
    }
}
