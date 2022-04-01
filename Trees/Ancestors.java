import java.util.ArrayList;

public class Ancestors {
    static boolean find(Node root, int target, ArrayList<Integer> al) {
        if (root == null)
            return false;
        if (root.data == target)
            return true;
        if (find(root.left, target, al) ||
                find(root.right, target, al)) {
            al.add(root.data);
            return true;
        }
        return false;
    }

    static ArrayList<Integer> ancestors(Node root, int target) {
        ArrayList<Integer> al = new ArrayList<>();

        find(root, target, al);

        return al;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        i.inOrder(root);
        System.out.println();
        ArrayList<Integer> al = ancestors(root, 2);

        for (Integer e : al)
            System.out.print(e + " ");
    }
}
