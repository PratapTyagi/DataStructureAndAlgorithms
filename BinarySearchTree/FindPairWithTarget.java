public class FindPairWithTarget {
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
        return isPresent(root, root, target);
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3 };

        BSTImplementation i = new BSTImplementation();
        BSTNode root = i.construct(arr, 0, arr.length - 1);

        System.out.println(isPairPresent(root, 3));
    }
}
