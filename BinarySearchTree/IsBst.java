package BinarySearchTree;

public class IsBst {

    static boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data >= max || root.data <= min) {
            return false;
        }

        boolean left = checkBST(root.left, min, root.data);
        boolean right = checkBST(root.right, root.data, max);
        return left && right;
    }

    static boolean isBst(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] a) {
        Integer[] arr = { 1, 1, 1, 1, 1, null, 1, 1, 1, 1, 1 };

        Implementation i = new Implementation();
        Node root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);

        System.out.println(isBst(root));
    }
}
