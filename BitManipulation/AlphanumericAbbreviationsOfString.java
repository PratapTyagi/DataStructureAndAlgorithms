public class AlphanumericAbbreviationsOfString {
    /*
     * Abreviations :
     * 000 pep
     * 001 pe1
     * 010 p1p
     * 011 p2
     * 100 1ep
     * 101 1e1
     * 110 2p
     * 111 3
     */

    static void solve(String str) {
        int n = str.length();
        for (int i = 0; i < (1 << n); i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                int bit = str.length() - 1 - j;

                if ((i & (1 << bit)) != 0)
                    count++;
                else {
                    if (count == 0)
                        sb.append(ch);
                    else {
                        sb.append(count);
                        sb.append(ch);
                        count = 0;
                    }
                }
            }
            if (count != 0)
                sb.append(count);
            System.out.println(sb.toString());
        }

    }

    public static void main(String[] args) {
        String str = "pep";
        solve(str);
    }
}
