import java.util.ArrayList;

public class SortAnArray2 {
    private static void insert(ArrayList<Integer> arr, int val) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= val) {
            arr.add(val);
            return;
        }
        int temp = arr.remove(arr.size() - 1);
        insert(arr, val);
        arr.add(temp);
    }

    private static void sort(ArrayList<Integer> arr) {
        if (arr.size() <= 1)
            return;
        int temp = arr.remove(arr.size() - 1);
        sort(arr);
        insert(arr, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] input = { 5, 4, 3, 2, 1 };
        for (int i : input)
            al.add(i);

        sort(al);
        for (int i : al)
            System.out.print(i + " ");
    }
}
