public class SumTwoLargeNumbers {
    static String findSum(String X, String Y) {
        java.math.BigInteger a = new java.math.BigInteger(X);
        java.math.BigInteger b = new java.math.BigInteger(Y);
        return a.add(b).toString();
    }

    public static void main(String[] args) {
        String X = "2500", Y = "23";
        System.out.println(findSum(X, Y));
    }
}
