import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class IXTopView {
    private static class Pair {
        Node node;
        int count;

        Pair(Node n, int c) {
            node = n;
            count = c;
        }
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        if (root == null)
            return new ArrayList<>();

        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair top = q.poll();

            map.putIfAbsent(top.count, top.node.data);

            if (top.node.left != null)
                q.add(new Pair(top.node.left, top.count - 1));
            if (top.node.right != null)
                q.add(new Pair(top.node.right, top.count + 1));
        }

        return new ArrayList<Integer>(map.values());
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al = topView(root);

        for (Integer ele : al)
            System.out.print(ele + " ");
    }
}
