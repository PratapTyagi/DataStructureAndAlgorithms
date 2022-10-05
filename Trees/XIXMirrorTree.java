public class XIXMirrorTree {
    static void mirror(Node root) {
        if (root == null) {
            return;
        }

        Node left = root.left;
        root.left = root.right;
        root.right = left;

        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 10, 20, 40, null, null, 60, null, null, 30, null, null };
        Node root = new Node(arr1[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr1, root);
        i.inOrder(root);
        System.out.println();

        mirror(root);
        i.inOrder(root);
    }
}
