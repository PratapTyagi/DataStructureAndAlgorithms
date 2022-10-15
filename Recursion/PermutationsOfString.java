import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfString {
    static void solve(List<String> ans, String s, int i) {
        if (i == s.length()) {
            ans.add(s);
            return;
        }

        for (int k = i; k < s.length(); k++) {
            s = swap(s, i, k);
            solve(ans, s, i + 1);
            s = swap(s, i, k);
        }

    }

    static String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }

    static List<String> find_permutation(String s) {
        List<String> ans = new ArrayList<>();
        solve(ans, s, 0);

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        String s = "ABC";
        List<String> ans = find_permutation(s);
        for (String ele : ans)
            System.out.print(ele + " ");

    }
}
