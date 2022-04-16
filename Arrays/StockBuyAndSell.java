import java.util.ArrayList;
import java.util.Arrays;

public class StockBuyAndSell {
    static ArrayList<ArrayList<Integer>> stockBuySell(int arr[], int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i])
                count++;
            else {
                if (count > 0)
                    ans.add(new ArrayList<Integer>(Arrays.asList(i - count - 1, i - 1)));
                count = 0;
            }
        }
        if (count > 0)
            ans.add(new ArrayList<Integer>(Arrays.asList(n - count - 1, n - 1)));

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 2, 2, 4 };

        ArrayList<ArrayList<Integer>> ans = stockBuySell(arr, arr.length);

        for (ArrayList<Integer> a : ans)
            System.out.println(a.get(0) + " " + a.get(1));
    }
}
