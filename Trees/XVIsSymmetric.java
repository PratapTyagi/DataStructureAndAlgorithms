public class XVIsSymmetric {

    static boolean isSymmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public static void main(String[] a) {
        Integer[] arr = { 1, 2, null, 3, 2, null, 3 };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        i.inOrder(root);

        // Is Symmetric
        System.out.println(isSymmetric(root, root));
    }
}