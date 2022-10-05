public class XXIMaximumSumLeafToRootPath {
    static int max(Node root) {
        if (root == null)
            return 0;

        return Math.max(max(root.left), max(root.right)) + root.data;
    }

    static int maxPathSum(Node root) {
        if (root == null)
            return 0;

        return max(root);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        System.out.println(maxPathSum(root));
    }
}