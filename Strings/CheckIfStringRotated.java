public class CheckIfStringRotated {
    static boolean isRotated(String a, String b) {
        if (a.equals(b)) {
            return true;
        }
        String start = b.substring(0, 2);
        String end = b.substring(b.length() - 2);
        String mid = b.substring(2, b.length() - 2);
        b = end + start + mid;
        if (a.equals(b)) {
            return true;
        }
        b = end + mid + start;
        if (a.equals(b)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a, b));
    }
}
