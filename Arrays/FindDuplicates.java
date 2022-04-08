import java.util.ArrayList;

public class FindDuplicates {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
            arr[arr[i] % n] += n;

        for (int i = 0; i < n; i++)
            if (arr[i] / n > 1)
                al.add(i);

        if (al.size() == 0) {
            al.add(-1);
            return al;
        }
        return al;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 2, 3 };
        ArrayList<Integer> al = duplicates(arr, arr.length);

        for (int i : al)
            System.out.print(i + " ");
    }
}