public class CountNumberOfSubTreesHavingSum {
    static int ans = 0;

    static int solve(Node root, int x) {
        if (root == null)
            return 0;

        int sum = 0;
        sum += root.data;
        sum += solve(root.left, x);
        sum += solve(root.right, x);

        if (sum == x)
            ans++;
        return sum;
    }

    static int countSubtreesWithSumX(Node root, int x) {
        solve(root, x);
        int result = ans;
        ans = 0;
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = { 5, -10, 9, null, null, 8, null, null, 3, -4, null, null, 7, null, null };
        Node root = new Node(arr[0]);

        Implementation i = new Implementation();
        // We got our binary tree
        i.createBinaryTree(arr, root);
        // Traverse
        // i.inOrder(root);

        System.out.println(countSubtreesWithSumX(root, 7));
    }
}
