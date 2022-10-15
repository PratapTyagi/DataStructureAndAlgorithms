import java.util.HashSet;

public class ValidateIPAddress {
    static boolean isValid(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 1; i < n; i++) {
            char currChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);
            if (currChar == '.')
                count++;
            if (currChar == '.' && prevChar == '.')
                return false;
        }

        if (count != 3)
            return false;

        HashSet<String> hs = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        count = 0;

        for (int i = 0; i < 256; i++)
            hs.add(Integer.toString(i));

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '.')
                temp.append(c);
            else {
                if (!hs.contains(temp.toString()))
                    return false;
                temp.setLength(0);
            }
        }

        if (!hs.contains(temp.toString()))
            return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("5555..555"));
    }
}
