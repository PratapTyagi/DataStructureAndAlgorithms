import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniquePermutationsOfArray {
    static void solve(ArrayList<Integer> ipt, Set<ArrayList<Integer>> set, int i) {
        if (i == ipt.size()) {
            set.add(new ArrayList<Integer>(ipt));
            return;
        }

        for (int k = i; k < ipt.size(); k++) {
            swap(ipt, i, k);
            solve(ipt, set, i + 1);
            swap(ipt, i, k);
        }
    }

    static void swap(ArrayList<Integer> ipt, int i, int j) {
        int temp = ipt.get(i);
        ipt.set(i, ipt.get(j));
        ipt.set(j, temp);
        return;
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        Set<ArrayList<Integer>> set = new LinkedHashSet<>();
        solve(arr, set, 0);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>(set);

        Collections.sort(ans, (o1, o2) -> {
            int i = 0;
            while (o1.get(i) == o2.get(i))
                i++;
            return o1.get(i).compareTo(o2.get(i));
        });

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 1));
        ArrayList<ArrayList<Integer>> ans = uniquePerms(al, al.size());

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
            }
            System.out.println();
        }
    }
}
