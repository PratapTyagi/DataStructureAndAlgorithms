public class BalancedTree {

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        int otp = Math.abs(height(root.left) - height(root.right));

        if (otp > 1 || left == false || right == false) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, 1, 0, null, null, null, null };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        i.inOrder(root);

        System.out.println();
        System.out.println(isBalanced(root));
    }
}
