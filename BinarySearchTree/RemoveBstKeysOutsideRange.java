class RemoveBstKeysOutsideRange {
    static BSTNode removekeys(BSTNode root, int l, int r) {
        if (root == null)
            return root;

        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        if (root.data > r) {
            BSTNode left = root.left;
            root = null;
            return left;
        }
        if (root.data < l) {
            BSTNode right = root.right;
            root = null;
            return right;
        }

        return root;
    }

    public static void main(String[] args) {
        BSTImplementation i = new BSTImplementation();
        Integer[] arr = { 1, 2, 3 };

        BSTNode root = i.construct(arr, 0, arr.length - 1);

        root = removekeys(root, 0, 1);

        i.inOrder(root);
    }
}
