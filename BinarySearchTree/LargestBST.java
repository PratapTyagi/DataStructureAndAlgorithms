import java.util.ArrayList;

public class LargestBST {
    static void helper(BSTNode root, ArrayList<Integer> al) {
        if (root == null)
            return;

        helper(root.left, al);
        al.add(root.data);
        helper(root.right, al);
    }

    static boolean isBST(BSTNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        helper(root, al);

        for (int i = 1; i < al.size(); i++)
            if (al.get(i) <= al.get(i - 1))
                return false;
        return true;
    }

    static int numberOfNodes(BSTNode root) {
        if (root == null)
            return 0;

        return 1 + numberOfNodes(root.left) + numberOfNodes(root.right);
    }

    static int largestBst(BSTNode root) {
        if (root == null)
            return 0;

        if (isBST(root))
            return numberOfNodes(root);

        int left = largestBst(root.left);
        int right = largestBst(root.right);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 0, 2, 3, 5 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);
        System.out.println("\n" + largestBst(root));
    }
}
