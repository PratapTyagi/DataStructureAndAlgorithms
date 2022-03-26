public class SingleValuedSubtree {
    static boolean isUnivalue(Node root, int x) {
        if (root == null)
            return true;
        if (root.data != x)
            return false;

        return isUnivalue(root.left, x) && isUnivalue(root.right, x);
    }

    static void uniValue(Node root, int[] arr) {
        if (root == null)
            return;
        if (isUnivalue(root, root.data) == true)
            arr[0] += 1;
        uniValue(root.left, arr);
        uniValue(root.right, arr);
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
