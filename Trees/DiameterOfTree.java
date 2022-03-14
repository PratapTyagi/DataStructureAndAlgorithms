public class DiameterOfTree {

    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left);
        int right = diameter(root.right);
        int otp = height(root.left) + 1 + height(root.right);

        return Math.max(left, Math.max(right, otp));
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        i.inOrder(root);
        System.out.println();
        System.out.print(diameter(root));
    }
}
