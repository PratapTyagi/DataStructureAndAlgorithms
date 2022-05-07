class RankThePermutations {
    static void factorial(long[] fact, int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < n; i++)
            fact[i] = (i * fact[i - 1]);
    }

    static long findRank(String s) {
        int n = s.length();
        if (n == 1)
            return 1;

        int arr[] = new int[26];
        for (int i = 0; i < n; i++)
            arr[s.charAt(i) - 'a']++;

        long[] fact = new long[n];
        factorial(fact, n);

        long ans = 1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < s.charAt(i) - 'a'; j++)
                count += arr[j];
            arr[s.charAt(i) - 'a']--;
            ans += (count * fact[n - i - 1]);
        }

        return (ans);
    }

    public static void main(String[] args) {
        String s = "acb";
        System.out.println(findRank(s));
    }
}