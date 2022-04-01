class InOrderSuccessor {
    static BSTNode inorderSuccessor(BSTNode root, int x) {
        if (root == null) {
            return null;
        }

        BSTNode ans = null;
        BSTNode temp = root;
        while (temp != null) {
            if (temp.data > x) {
                ans = temp;
                temp = temp.left;
            } else
                temp = temp.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 0, 2, 3, 5 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);
        BSTNode node = inorderSuccessor(root, 2);
        System.out.println(node.data);
    }
}
