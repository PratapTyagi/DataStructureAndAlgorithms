import java.util.Arrays;

public class FindReplaceString {
    static String findAndReplace(String s, int q, int[] index, String[] sources, String[] targets) {
        int indexesLength = index.length;
        StringBuilder output = new StringBuilder();
        int n = s.length();
        int[] arr = new int[n];
        Arrays.fill(arr, -1);

        // Check matching element
        for (int i = 0; i < indexesLength; i++) {
            int ele = index[i];
            String matchElement = sources[i];
            int sourceLength = matchElement.length();

            String substr = s.substring(ele, ele + sourceLength);
            if (substr.equals(sources[i]))
                arr[ele] = i;
        }

        // Append to stringBuilder
        int idx = 0;
        while (idx < n) {
            if (arr[idx] >= 0) {
                output.append(targets[arr[idx]]);
                idx += sources[arr[idx]].length();
            } else
                output.append(s.charAt(idx++));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String S = "gforks";
        int Q = 2;
        int index[] = { 0, 3 };
        String sources[] = { "g", "ss" };
        String targets[] = { "geeks", "geeks" };
        System.out.println(findAndReplace(S, Q, index, sources, targets));
    }
}
