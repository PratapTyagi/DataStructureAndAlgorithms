import java.util.ArrayList;

public class CommonElements {
    static ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2 && k < n3) {
            if (a[i] == b[j] && a[i] == c[k]) {
                if (!al.contains(a[i]))
                    al.add(a[i]);
                i++;
                j++;
                k++;
            } else if (a[i] < b[j])
                i++;
            else if (b[j] < c[k])
                j++;
            else
                k++;
        }

        return al;
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 10, 20, 40, 80 };
        int[] b = { 6, 7, 20, 80, 100 };
        int[] c = { 3, 4, 15, 20, 30, 70, 80, 120 };

        ArrayList<Integer> common = commonElements(a, b, c, a.length, b.length, c.length);

        for (int e : common)
            System.out.print(e + " ");
    }
}
