public class ImplementAtoi {
    static int atoi(String s) {
        int num = 0;
        int n = s.length();
        int sign = 1;
        int i = 0;
        if (s.charAt(0) == '-') {
            i += 1;
            sign = -1;
        }

        for (; i < n; i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c))
                return -1;
            num = num * 10 + c - '0';
        }

        return num * sign;
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println(atoi(s));
    }
}
