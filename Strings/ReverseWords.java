public class ReverseWords {
    public static void main(String[] args) {
        String s = "i.like.this.program.very.much";

        String[] str = s.split("\\.");
        String string = "";
        for (int i = str.length - 1; i >= 0; i--) {
            if (i == 0) {
                string += str[i];
                break;
            }
            string += str[i] + ".";
        }

        System.out.println(string);
    }
}
