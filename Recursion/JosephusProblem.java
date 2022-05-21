import java.util.ArrayList;

public class JosephusProblem {
    static void solve(ArrayList<Integer> al, int k, int index, int[] ans) {
        if (al.size() == 1) {
            ans[0] = al.get(0);
            return;
        }

        index = (index + k) % al.size();
        al.remove(index);

        solve(al, k, index, ans);
        return;
    }

    static int josephus(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] ans = new int[1];

        for (int i = 1; i <= n; i++)
            al.add(i);

        k--;
        solve(al, k, 0, ans);

        return ans[0];
    }

    public static void main(String[] args) {
        int n = 40, k = 7;
        System.out.println(josephus(n, k));
    }
}
