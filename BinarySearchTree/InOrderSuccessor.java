package BinarySearchTree;

class InOrderSuccessor {
    static Node inorderSuccessor(Node root, int x) {
        if (root == null) {
            return null;
        }

        Node ans = null;
        Node temp = root;
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

        Implementation i = new Implementation();
        Node root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);
        Node node = inorderSuccessor(root, 2);
        System.out.println(node.data);
    }
}
