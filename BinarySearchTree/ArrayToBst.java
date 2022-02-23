package BinarySearchTree;

import java.util.ArrayList;

public class ArrayToBst {

    static void inOrder(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;
        al.add(root.data);
        inOrder(root.left, al);
        inOrder(root.right, al);
    }

    public static void main(String[] a) {
        Integer[] arr = { 0, 2, 3, 5 };

        Implementation i = new Implementation();
        Node root = i.construct(arr, 0, arr.length - 1);

        ArrayList<Integer> al = new ArrayList<>(arr.length);
        inOrder(root, al);

        int[] otp = al.stream().mapToInt(x -> x).toArray();
        for (int j : otp) {
            System.out.print(j + " ");
        }
    }
}
