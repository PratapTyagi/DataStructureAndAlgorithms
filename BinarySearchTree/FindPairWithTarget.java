import java.util.Stack;

public class FindPairWithTarget {
    private static class BSTIterator {
        Stack<BSTNode> stack = new Stack<>();
        boolean isReversed = false;

        public BSTIterator(BSTNode root, boolean isReversed) {
            pushAll(root);
            this.isReversed = isReversed;
        }

        private void pushAll(BSTNode root) {
            while (root != null) {
                stack.push(root);
                if (!isReversed)
                    root = root.left;
                else
                    root = root.right;
            }
        }

        public int next() {
            BSTNode tempNode = stack.pop();
            if (isReversed)
                pushAll(tempNode.left);
            else
                pushAll(tempNode.right);
            return tempNode.data;
        }

        // public boolean hasNext() {
        // return !stack.isEmpty();
        // }
    }

    static boolean find(BSTNode root, int complement) {
        if (root == null)
            return false;
        if (root.data < complement)
            return find(root.right, complement);
        else if (root.data > complement)
            return find(root.left, complement);
        return true;
    }

    static int isPresent(BSTNode root, BSTNode node, int target) {
        if (root == null)
            return 0;

        int left = isPresent(root.left, node, target);

        int complement = target - root.data;
        if (complement > root.data)
            if (find(node, complement) == true)
                return 1;

        int right = isPresent(root.right, node, target);

        return left == 1 || right == 1 ? 1 : 0;
    }

    static int isPairPresent(BSTNode root, int target) {
        // return isPresent(root, root, target); // O(N^2) time, O(1) space complexity

        // Approch 2 O(N) time and space complexity
        // Store in order in array and then use 2sum approch to find target presence

        // Approch 3
        // BST Iterator Time ≈ O(1) and space O(ht)

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == target)
                return 1;
            if (i + j < target)
                i = l.next();
            else
                j = r.next();
        }

        return 0;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        System.out.println(isPairPresent(root, 3));
    }
}
