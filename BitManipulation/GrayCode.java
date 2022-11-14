import java.util.ArrayList;

public class GrayCode {
    static ArrayList<String> solution(int n) {
        if (n == 1) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("0");
            bres.add("1");
            return bres;
        }

        ArrayList<String> rres = solution(n - 1);
        ArrayList<String> mres = new ArrayList<>();

        for (int i = 0; i < rres.size(); i++)
            mres.add("0" + rres.get(i));

        for (int i = rres.size() - 1; i >= 0; i--)
            mres.add("1" + rres.get(i));

        return mres;
    }

    public static void main(String[] args) {
        int n = 3;
        /*
         * If n = 3 i.e. 3-bits are max value
         * 000 001 011 010 110 111 101 100
         * all the num should have change in just single bit
         */
        ArrayList<String> res = solution(n);

        for (String ele : res)
            System.out.print(ele + " ");
    }
}
