public class MinimumTimesARepeatedBIsSubstring {
    static int minRepeats(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        if (n1 > n2)
            return -1;

        StringBuilder temp = new StringBuilder();
        int count = 0;
        while (!temp.toString().contains(b)) {
            temp.append(a);
            count++;
            if (temp.length() > 2 * n2)
                return -1;
        }

        return count;
    }

    public static void main(String[] args) {
        String A = "ab", B = "cab";
        System.out.println(minRepeats(A, B));
    }
}
