import java.util.ArrayList;

public class BSTToMaxHeap {
    static void inOrder(BSTNode root, ArrayList<Integer> al) {
        if (root == null)
            return;

        inOrder(root.left, al);
        al.add(root.data);
        inOrder(root.right, al);
        return;
    }

    static void postOrder(BSTNode root, ArrayList<Integer> al) {
        if (root == null)
            return;

        postOrder(root.left, al);
        postOrder(root.right, al);

        root.data = al.remove(0);
        return;
    }

    public static void convertToMaxHeapUtil(BSTNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();

        inOrder(root, al);
        postOrder(root, al);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        convertToMaxHeapUtil(root);
        i.inOrder(root);
    }
}
