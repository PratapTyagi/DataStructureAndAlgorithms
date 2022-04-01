import java.util.HashMap;

public class MaximumSumOfNonAdjacentNodes {
    static int find(BSTNode root, HashMap<BSTNode, Integer> map) {
        if (root == null)
            return 0;

        if (map.containsKey(root))
            return map.get(root);

        int include = 0;

        if (root.left != null)
            include += find(root.left.right, map) + find(root.left.left, map);
        if (root.right != null)
            include += find(root.right.right, map) + find(root.right.left, map);

        int exclude = find(root.left, map) + find(root.right, map);

        map.put(root, Math.max(include + root.data, exclude));

        return Math.max(include + root.data, exclude);
    }

    // Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(BSTNode root) {
        HashMap<BSTNode, Integer> map = new HashMap<>();
        return find(root, map);
    }

    public static void main(String[] args) {
        Integer[] arr = { 0, 2, 3, 5 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        i.inOrder(root);
        System.out.println("\n" + getMaxSum(root));
    }
}
