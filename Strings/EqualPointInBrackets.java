public class EqualPointInBrackets {
    static int find(String s) {
        int n = s.length();
        int[] openBrackets = new int[n + 1];
        int[] closeBrackets = new int[n + 1];

        openBrackets[0] = 0;
        closeBrackets[n] = 0;

        if (s.charAt(0) == '(') {
            openBrackets[1] = 1;
        }
        if (s.charAt(n - 1) == ')') {
            closeBrackets[n - 1] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '(')
                openBrackets[i + 1] = openBrackets[i] + 1;
            else
                openBrackets[i + 1] = openBrackets[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == ')')
                closeBrackets[i] = closeBrackets[i + 1] + 1;
            else
                closeBrackets[i] = closeBrackets[i + 1];
        }

        if (openBrackets[n] == 0) {
            return n;
        }
        if (closeBrackets[0] == 0) {
            return 0;
        }

        int index = -1;
        for (int i = 0; i <= n; i++) {
            if (openBrackets[i] == closeBrackets[i]) {
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        String str = "(())))(";
        System.out.println(find(str));
    }
}
