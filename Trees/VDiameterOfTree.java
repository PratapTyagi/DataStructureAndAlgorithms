public class VDiameterOfTree {

    static int diameter(Node root, int[] res) {
        if (root == null) {
            return 0;
        }

        int left = diameter(root.left, res);
        int right = diameter(root.right, res);
        int temp = 1 + Math.max(left, right);
        int ans = Math.max(left + 1 + right, temp);
        res[0] = Math.max(ans, res[0]);

        return temp;
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 20, 5, null, null, 3, null, 9, null, 0, null, null, 30 };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        i.inOrder(root);
        System.out.println();
        int[] res = { 0 };
        diameter(root, res);
        System.out.print(res[0]);
    }
}
