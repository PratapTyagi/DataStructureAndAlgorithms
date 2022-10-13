public class CheckIfStringRotated {
    static boolean isRotated(String a, String b) {
        return (a.length() == b.length()) && ((a + a).indexOf(b) != -1);
    }

    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a, b));
    }
}
