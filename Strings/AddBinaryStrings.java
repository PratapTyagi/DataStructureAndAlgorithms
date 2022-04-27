public class AddBinaryStrings {
    static String addBinary(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        if (n1 < n2)
            return addBinary(b, a);

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = n1 - 1, j = n2 - 1;

        while (i >= 0 && j >= 0) {
            int first = a.charAt(i) - '0';
            int second = b.charAt(j) - '0';

            if (first == 1 && second == 1) {
                if (carry == 1)
                    sb.append('1');
                else
                    sb.append('0');
                carry = 1;
            } else if (first == 0 && second == 0) {
                if (carry == 1) {
                    sb.append('1');
                    carry = 0;
                } else
                    sb.append('0');
            } else if (first == 1 && second == 0 || first == 0 && second == 1) {
                if (carry == 1) {
                    sb.append('0');
                    carry = 1;
                } else
                    sb.append('1');
            }
            i--;
            j--;
        }

        while (i >= 0) {
            int first = a.charAt(i) - '0';
            if (first == 0) {
                if (carry == 1) {
                    sb.append('1');
                    carry = 0;
                } else
                    sb.append('0');
            } else {
                if (carry == 1)
                    sb.append('0');
                else
                    sb.append('1');
            }
            i--;
        }

        if (carry == 1)
            sb.append('1');

        String output = sb.reverse().toString();
        i = 0;
        while (output.charAt(i) == '0')
            i++;

        return output.substring(i);
    }

    public static void main(String[] args) {
        String A = "1101", B = "0111";
        System.out.println(addBinary(A, B));
    }
}
