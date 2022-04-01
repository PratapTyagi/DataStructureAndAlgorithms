public class SumTree {
    static int sumNodes(BSTNode root) {
        if (root == null)
            return 0;

        return sumNodes(root.left) + sumNodes(root.right) + root.data;
    }

    static boolean isSumTree(BSTNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int left = sumNodes(root.left);
        int right = sumNodes(root.right);
        if (left + right != root.data)
            return false;

        return isSumTree(root.left) && isSumTree(root.right);
    }

    public static void main(String[] args) {
        Integer[] arr = { 0, 2, 3, 5 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        System.out.println(isSumTree(root));
    }

}