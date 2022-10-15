import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestWordInDictionary {
    static String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        int n1 = s.length();
        StringBuilder res = new StringBuilder();

        for (String ele : d) {
            int j = 0, k = 0;
            int n2 = ele.length();
            if (n2 > n1)
                continue;
            while (j < n2 && k < n1) {
                if (ele.charAt(j) == s.charAt(k))
                    j++;
                k++;
            }
            if (j == n2 && res.length() < ele.length()) {
                res.setLength(0);
                res.append(ele);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        ArrayList<String> d = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"));
        String s = "abpcplea";
        System.out.println(findLongestWord(s, d));
    }
}
