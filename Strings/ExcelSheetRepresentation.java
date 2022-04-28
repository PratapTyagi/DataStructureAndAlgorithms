public class ExcelSheetRepresentation {
    static String excelColumn(int N) {
        String str = "";

        while (N > 0) {
            char c = (char) ('A' + (N - 1) % 26);
            str = c + str;
            N = (N - 1) / 26;
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(excelColumn(52));
    }
}
