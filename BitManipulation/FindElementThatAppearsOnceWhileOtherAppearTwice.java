public class FindElementThatAppearsOnceWhileOtherAppearTwice {
    /*
     * Xor having same bit results to 0 and diff bits results 1
     * 
     * Xor values are:
     * commutative -> a^b^c = a^(b^c) = (a^b)^c
     * associative -> a^b = b^a
     */

    static int search(int A[], int N) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans ^= A[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] A = { 1, 1, 2, 5, 5 };
        System.out.println(search(A, N));
    }
}
