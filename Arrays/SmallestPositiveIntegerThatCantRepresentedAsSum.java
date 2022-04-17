import java.util.Arrays;

public class SmallestPositiveIntegerThatCantRepresentedAsSum {
    static long smallestpositive(long[] arr, int n) {
        Arrays.sort(arr);

        long ans = 1;
        for (long i : arr) {
            if (ans < i)
                return ans;
            else
                ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 1, 1 };
        System.out.println(smallestpositive(arr, arr.length));
    }
}