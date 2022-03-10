import java.util.Stack;

public class MaximumPathSumFromNode {
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

    static int maximum(Node root, CallByReference res) {
        if (root == null)
            return 0;

        int left = maximum(root.left, res);
        int right = maximum(root.right, res);

        int temp = Math.max(root.data, Math.max(left, right) + root.data);
        int ans = Math.max(temp, root.data + left + right);

        res.changeValue(Math.max(ans, res.fetch()));
        return temp;
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

        CallByReference res = new CallByReference(Integer.MIN_VALUE);
        createBinaryTree(arr, root);
        maximum(root, res);
        System.out.print(res.fetch());
    }
}
