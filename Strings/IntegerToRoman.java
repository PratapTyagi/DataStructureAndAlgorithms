public class IntegerToRoman {
    static String convertToRoman(int n) {
        int[] num = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        String res = "";

        int i = 0;
        while (n > 0) {
            if (n >= num[i]) {
                res += romans[i];
                n -= num[i];
                i--;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 916;
        System.out.println(convertToRoman(n));
    }
}
