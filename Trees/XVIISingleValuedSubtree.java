public class XVIISingleValuedSubtree {
    static boolean uniValue(Node root, int[] arr) {
        if (root == null)
            return true;
        boolean left = uniValue(root.left, arr);
        boolean right = uniValue(root.right, arr);

        if (left == false || right == false)
            return false;

        if (root.left != null && root.left.data != root.data)
            return false;

        if (root.right != null && root.right.data != root.data)
            return false;

        arr[0]++;
        return true;
    }

    public static int singlevalued(Node root) {
        int[] arr = new int[1];
        uniValue(root, arr);
        return arr[0];
    }

    public static void main(String[] args) {
        Integer[] arr = { 5, 1, 5, null, null, 5, null, null, 5, null, 5, null, null };
        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        // i.inOrder(root);

        System.out.println(singlevalued(root));
    }
}
