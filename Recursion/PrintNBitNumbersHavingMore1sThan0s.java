import java.util.ArrayList;

public class PrintNBitNumbersHavingMore1sThan0s {
    static void solve(int ones, int zeros, int n, String otp, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(otp);
            return;
        }

        String otp1 = otp;
        otp1 += '1';

        solve(ones + 1, zeros, n - 1, otp1, ans);

        if (ones > zeros) {
            String otp2 = otp;
            otp2 += '0';

            solve(ones, zeros + 1, n - 1, otp2, ans);
        }

        return;
    }

    static ArrayList<String> NBitBinary(int N) {
        ArrayList<String> ans = new ArrayList<String>();
        solve(0, 0, N, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> ans = NBitBinary(4);
        for (String ele : ans)
            System.out.println(ele);
    }
}