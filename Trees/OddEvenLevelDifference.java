
public class OddEvenLevelDifference {
    static void difference(Node root, int level, int[] sumAtOdd, int[] sumAtEven) {
        if (root == null)
            return;

        if (level % 2 == 0)
            sumAtEven[0] += root.data;
        else
            sumAtOdd[0] += root.data;

        difference(root.left, level + 1, sumAtOdd, sumAtEven);
        difference(root.right, level + 1, sumAtOdd, sumAtEven);
    }

    static int getLevelDiff(Node root) {
        if (root == null)
            return 0;

        int[] sumAtOdd = new int[] { 0 };
        int[] sumAtEven = new int[] { 0 };
        difference(root, 1, sumAtOdd, sumAtEven);
        return sumAtOdd[0] - sumAtEven[0];
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        i.inOrder(root);
        System.out.println();
        System.out.println(getLevelDiff(root));
    }
}