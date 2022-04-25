public class LongestCommonPrefix {
    static String longestCommonPrefix(String arr[], int n) {
        String s = "";
        int i = 0;
        while (i < arr[0].length()) {
            char c = arr[0].charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (s.length() == 0 && arr[j].length() > i && c != arr[j].charAt(i))
                    return "-1";
                if (arr[j].length() > i && c != arr[j].charAt(i))
                    return s;

                if (arr[j].length() <= i)
                    return s;
            }
            s += c;
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
        String arr[] = new String[] { "geeksforgeeks", "geeks", "geek",
                "geezer" };

        System.out.println(longestCommonPrefix(arr, arr.length));
    }
}
