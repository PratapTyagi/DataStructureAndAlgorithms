import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {
    static void solve(int i, ArrayList<Integer> temp, ArrayList<Integer> input, ArrayList<ArrayList<Integer>> otp) {
        if (i == input.size()) {
            otp.add(temp);
            return;
        }

        solve(i + 1, new ArrayList<>(temp), input, otp);
        temp.add(input.get(i));
        solve(i + 1, new ArrayList<>(temp), input, otp);
    }

    static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> al) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(0, temp, al, ans);

        Collections.sort(ans, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i))
                    continue;
                else
                    return o1.get(i) - o2.get(i);
            }
            return 1;
        });

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(5, 6, 6, 10, 3, 4, 6, 6, 4));
        ArrayList<ArrayList<Integer>> otp = subsets(al);

        // Printing Subset
        for (int i = 0; i < otp.size(); i++) {
            for (int j = 0; j < otp.get(i).size(); j++) {
                System.out.print(otp.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
