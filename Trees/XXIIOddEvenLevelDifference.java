import java.util.ArrayDeque;

public class XXIIOddEvenLevelDifference {
    private static class Pair {
        Node node;
        int level;

        Pair(Node n, int l) {
            node = n;
            level = l;
        }
    }

    static void difference(Node root, int l, int[] sumAtOdd, int[] sumAtEven) {
        // if (root == null)
        // return;

        // if (level % 2 == 0)
        // sumAtEven[0] += root.data;
        // else
        // sumAtOdd[0] += root.data;

        // difference(root.left, level + 1, sumAtOdd, sumAtEven);
        // difference(root.right, level + 1, sumAtOdd, sumAtEven);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair top = q.poll();
            int level = top.level;
            Node node = top.node;
            if (level % 2 == 0)
                sumAtEven[0] += node.data;
            else
                sumAtOdd[0] += node.data;

            if (node.left != null)
                q.add(new Pair(node.left, level + 1));
            if (node.right != null)
                q.add(new Pair(node.right, level + 1));
        }
    }

    static int getLevelDiff(Node root) {
        if (root == null)
            return 0;

        int[] sumAtOdd = new int[] { 0 };
        int[] sumAtEven = new int[] { 0 };
        difference(root, 1, sumAtOdd, sumAtEven);
        return sumAtEven[0] - sumAtOdd[0];
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, null, null, 3, null, null };
        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        System.out.println(getLevelDiff(root));
    }
}