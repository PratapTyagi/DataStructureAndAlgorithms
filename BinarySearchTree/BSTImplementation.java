public class BSTImplementation {
    BSTNode construct(Integer[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        BSTNode leftChild = construct(arr, start, mid - 1);
        BSTNode rightChild = construct(arr, mid + 1, end);

        if (arr[mid] == null) {
            return null;
        }
        BSTNode node = new BSTNode(arr[mid], leftChild, rightChild);
        return node;
    }

    void inOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] a) {
        Integer[] arr = { 0, 2, 3, 5 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);
    }
}
