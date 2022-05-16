public class TowerOfHanoi {
    static long count = 0;

    static long toh(int n, int src, int dest, int helper) {
        count++;
        if (n == 1) {
            System.out.println("move disk 1 from rod " + src + " to rod " + dest);
            return count;
        }

        toh(n - 1, src, helper, dest);
        System.out.println("move disk " + n + " from rod " + src + " to rod " + dest);
        toh(n - 1, helper, dest, src);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(toh(3, 1, 3, 2));
    }
}