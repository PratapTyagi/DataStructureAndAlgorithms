package Trees;

public class IsSubtree {

    static boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    static boolean isSubtree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        if (areIdentical(root1, root2))
            return true;

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, null, null, 3, null, null };
        Integer[] arr2 = { 1, null, 4, null, null };
        Node root1 = new Node(arr1[0]);
        Node root2 = new Node(arr2[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr1, root1);
        i.createBinaryTree(arr2, root2);
        i.inOrder(root1);
        System.out.println();
        i.inOrder(root2);
        System.out.println();
        System.out.println(isSubtree(root1, root2));
    }
}
