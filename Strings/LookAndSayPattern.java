public class LookAndSayPattern {
    static String lookandsay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";

        String s = lookandsay(n - 1);
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) != s.charAt(i)) {
                sb.append(count).append(s.charAt(i));
                count = 1;
            } else
                count++;
        }
        if (count == 2)
            sb.append(count).append(s.charAt(s.length() - 1));
        else
            sb.append("1").append(s.charAt(s.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookandsay(5));
    }
}
