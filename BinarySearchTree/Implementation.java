package BinarySearchTree;

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data, Node lefNode, Node rightNode) {
        this.data = data;
        left = lefNode;
        right = rightNode;
    }
}

public class Implementation {
    Node construct(Integer[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node leftChild = construct(arr, start, mid - 1);
        Node rightChild = construct(arr, mid + 1, end);

        if (arr[mid] == null) {
            return null;
        }
        Node node = new Node(arr[mid], leftChild, rightChild);
        return node;
    }

    void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] a) {
        Integer[] arr = { 0, 2, 3, 5 };

        Implementation i = new Implementation();
        Node root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);
    }
}
