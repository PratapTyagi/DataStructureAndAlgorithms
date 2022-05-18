import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSumRecursive {
    static void solve(ArrayList<Integer> ipt, ArrayList<Integer> ans, int sum, int i) {
        if (i == ipt.size()) {
            ans.add(sum);
            return;
        }

        solve(ipt, ans, sum + ipt.get(i), i + 1);
        solve(ipt, ans, sum, i + 1);
        return;
    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(arr, ans, 0, 0);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 2, 1, 1));
        ArrayList<Integer> otp = subsetSums(arr);
        for (int ele : otp)
            System.out.print(ele + " ");
    }
}
