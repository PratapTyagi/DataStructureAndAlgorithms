public class XXIVMinimumDistanceBetweenTwoNodes {
    static Node lca(Node root, int a, int b) {
        if (root == null)
            return null;

        if (root.data == a || root.data == b)
            return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    static int pathHeight(Node root, int a, int height) {
        if (root == null)
            return Integer.MAX_VALUE;

        if (root.data == a)
            return height;

        int l = pathHeight(root.left, a, height + 1);
        int r = pathHeight(root.right, a, height + 1);

        return Math.min(l, r);
    }

    static int findDist(Node root, int a, int b) {
        int aPathHeight = pathHeight(root, a, 0);
        int bPathHeight = pathHeight(root, b, 0);
        int extraHeight = pathHeight(root, lca(root, a, b).data, 0);

        return aPathHeight + bPathHeight - (2 * extraHeight);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, null, null, null, null };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        i.inOrder(root);

        Node lcaNode = lca(root, 1, 3);
        System.out.println("\n" + lcaNode.data);
    }
}
