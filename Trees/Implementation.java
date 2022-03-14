import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Implementation {

    static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    void createBinaryTree(Integer[] arr, Node root) {
        Pair pair = new Pair(root, 1);

        Stack<Pair> stack = new Stack<>();
        stack.add(pair);

        int index = 0;
        while (stack.size() > 0) {
            Pair top = stack.peek();

            if (top.state == 1) {
                ++index;
                if (index < arr.length && arr[index] != null) {
                    top.node.left = new Node(arr[index]);
                    stack.add(new Pair(top.node.left, 1));
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                ++index;
                if (index < arr.length && arr[index] != null) {
                    top.node.right = new Node(arr[index]);
                    stack.add(new Pair(top.node.right, 1));
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }

    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        i.inOrder(root);
    }
}
