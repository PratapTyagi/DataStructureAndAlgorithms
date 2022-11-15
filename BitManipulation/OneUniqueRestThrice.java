public class OneUniqueRestThrice {
    /*
     * Method 1
     * calculate bits for each position now the bit which are
     * 3n in total comes only when the single no. is off (0) at that position
     * 3n+1 means on (1)
     * 
     * Time complexity -> O(32N)
     * 
     * Method 2
     * Implementation below
     */
    static int singleElement(int[] arr, int N) {
        int tn = -1, tnp1 = 0, tnp2 = 0;

        for (int i = 0; i < N; i++) {
            int commonWith3n = arr[i] & tn;
            int commonWith3np1 = arr[i] & tnp1;
            int commonWith3np2 = arr[i] & tnp2;

            /*
             * we are setting and with both because if it's present before and now too that
             * means it has become 3n+1 nature
             */
            tn = tn & (~commonWith3n);
            tnp1 = tnp1 | commonWith3n;

            tnp1 = tnp1 & (~commonWith3np1);
            tnp2 = tnp2 | commonWith3np1;

            // storing in 3n (tn) because it has become 3n+3 nature which 3n nature only
            tnp2 = tnp2 & (~commonWith3np2);
            tn = tn | commonWith3np2;
        }

        return tnp1;
    }

    public static void main(String[] args) {
        int N = 4,
                arr[] = { 1, 10, 1, 1 };
        System.out.println(singleElement(arr, N));
    }
}
