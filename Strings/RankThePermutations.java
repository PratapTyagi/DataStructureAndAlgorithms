class RankThePermutations {
    static void factorial(int[] fact, int n) {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < n; i++)
            fact[i] = (i * fact[i - 1]);
    }

    static int findRank(String s) {
        int n = s.length();
        if (n == 1)
            return 1;

        // Pre calculated factorial
        int[] fact = new int[26];
        factorial(fact, 26);

        int[] arr = new int[256];

        // Assigning each alphabet corresponding value as 1
        // If repeats then return 0
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)] == 1)
                return 0;
            arr[s.charAt(i)] = 1;
        }

        int ans = 0;
        int noOfLettersSmaller;
        for (int i = 0; i < n; i++) {
            noOfLettersSmaller = 0;

            // All the smaller values count
            for (int j = 0; j < 256; j++) {
                if (j == s.charAt(i))
                    break;
                if (arr[j] == 1)
                    noOfLettersSmaller++;
            }

            // Mark curr char visited
            arr[s.charAt(i)] = 0;

            // Permutations before a char = smaller letters * fact(ways of arrangements)
            ans += noOfLettersSmaller * fact[n - 1 - i];
        }

        return (ans + 1) % 1000003; // ans + 1 for word position
    }

    public static void main(String[] args) {
        String s = "vsrtkjpre";
        System.out.println(findRank(s));
    }
}