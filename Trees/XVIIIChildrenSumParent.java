public class XVIIIChildrenSumParent {

    static int isSumProperty(Node root) {
        if (root == null) {
            return 1;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int otp = 0;
        if (root.left != null) {
            otp += root.left.data;
        }
        if (root.right != null) {
            otp += root.right.data;
        }

        if (otp != root.data) {
            return 0;
        }

        int left = isSumProperty(root.left);
        int right = isSumProperty(root.right);

        if (left == 0 || right == 0) {
            return 0;
        }
        return 1;
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
        System.out.println(isSumProperty(root));
    }
}
