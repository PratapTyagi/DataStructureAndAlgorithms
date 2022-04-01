import java.util.PriorityQueue;

public class KthLargestElement {
    static void largest(BSTNode root, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }

        largest(root.left, queue);
        largest(root.right, queue);
        queue.add(root.data);
    }

    static int kthLargest(BSTNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        largest(root, queue);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            ans = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 10, 1, 51, 3, 0 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);

        System.out.println();
        int ans = kthLargest(root, 2);
        System.out.println(ans);
    }
}
