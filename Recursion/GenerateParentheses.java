import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    static void solve(List<String> ans, int open, int close, String temp) {
        if (open == 0 && close == 0) {
            ans.add(temp);
            return;
        }

        if (open != 0) {
            String otp = temp;
            otp += "(";
            solve(ans, open - 1, close, otp);
        }

        if (open < close) {
            String otp = temp;
            otp += ")";
            solve(ans, open, close - 1, otp);
        }
        return;
    }

    static List<String> AllParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        int open = n;
        int close = n;

        solve(ans, open, close, "");

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = AllParenthesis(n);

        for (String string : ans)
            System.out.println(string);
    }
}
