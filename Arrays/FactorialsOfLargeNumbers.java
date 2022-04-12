import java.util.ArrayList;

public class FactorialsOfLargeNumbers {
    static ArrayList<Integer> factorial(int N) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        java.math.BigInteger F;
        F = java.math.BigInteger.valueOf(1);

        for (int i = 2; i <= N; i++)
            F = F.multiply(java.math.BigInteger.valueOf(i));

        // BigInteger to string
        String value = F.toString();

        // now it can be added it to list
        for (int i = 0; i < value.length(); i++) {
            int k = Integer.parseInt(String.valueOf(value.charAt(i)));
            list.add(k);
        }

        return list;
    }

    public static void main(String[] args) {
        int n = 10;
        ArrayList<Integer> al = factorial(n);

        for (int i : al)
            System.out.print(i);

    }
}
