public class IIIHeightOfBinaryTree {
    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        i.inOrder(root);
        System.out.println();
        System.out.println(height(root));
    }
}
