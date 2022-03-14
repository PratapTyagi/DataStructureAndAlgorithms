class MaxGcdOfSiblings {

    static int[] maxGcdOfSiblings(Node root) {
        return new int[] {};
    }

    public static void main(String[] args) {
        Integer[] arr = { 4, 5, null, null, 2, 3, 6, null, null, 12, null, null, 1, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);

        i.inOrder(root);

        int[] ans = maxGcdOfSiblings(root);
    }
}