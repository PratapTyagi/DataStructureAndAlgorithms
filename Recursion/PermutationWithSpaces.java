import java.util.ArrayList;

public class PermutationWithSpaces {
    static void solve(String str, String temp, ArrayList<String> ans) {
        if (str.length() == 0) {
            ans.add(temp);
            return;
        }

        String temp1 = temp;
        String temp2 = temp;
        temp1 += " " + str.charAt(0);
        temp2 += str.charAt(0);
        str = str.substring(1);

        solve(str, temp1, ans);
        solve(str, temp2, ans);
    }

    static ArrayList<String> permutation(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        String str = "";
        str += s.charAt(0);
        s = s.substring(1);

        solve(s, str, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "ABC";

        ArrayList<String> otp = permutation(s);

        for (String ele : otp)
            System.out.print("(" + ele + ")");

    }
}
