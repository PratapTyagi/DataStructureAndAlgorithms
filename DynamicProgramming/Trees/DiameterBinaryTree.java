import java.util.Stack;

public class DiameterBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class CallByReference {
        private int a;

        public CallByReference(int x) {
            a = x;
        }

        public void changeValue(int x) {
            a = x;
        }

        public int fetch() {
            return a;
        }
    }

    static int solve(Node root, CallByReference res) {
        if (root == null)
            return 0;

        int left = solve(root.left, res);
        int right = solve(root.right, res);
        int temp = 1 + Math.max(left, right);
        int ans = Math.max(temp, 1 + left + right);
        res.changeValue(Math.max(ans, res.fetch()));

        return temp;
    }

    static int diameter(Node root) {
        CallByReference res = new CallByReference(Integer.MIN_VALUE);
        solve(root, res);
        return res.fetch();
    }

    static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    static void createBinaryTree(Integer[] arr, Node root) {
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

        createBinaryTree(arr, root);
        System.out.print(diameter(root));
    }
}
