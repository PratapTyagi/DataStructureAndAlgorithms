public class TwoTreesIdentical {

    static boolean identical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        boolean left = identical(root1.left, root2.left);
        boolean right = identical(root1.right, root2.right);
        if (left == false || right == false) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, null, null, 3, null, null };
        Integer[] arr2 = { 1, 3, null, null, 2, null, null };
        Node root1 = new Node(arr1[0]);
        Node root2 = new Node(arr2[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr1, root1);
        i.createBinaryTree(arr2, root2);
        i.inOrder(root1);
        System.out.println();
        i.inOrder(root2);
        System.out.println();
        System.out.println(identical(root1, root2));
    }
}
