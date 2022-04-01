import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;

public class VerticalTraversalBinaryTree {
    static class Pair {
        Node node;
        int breadth;

        public Pair(Node n, int b) {
            node = n;
            breadth = b;
        }
    }

    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Pair peek = queue.poll();

                if (map.containsKey(peek.breadth))
                    map.get(peek.breadth).add(peek.node.data);
                else
                    map.put(peek.breadth, new ArrayList<>(Arrays.asList(peek.node.data)));

                if (peek.node.left != null)
                    queue.add(new Pair(peek.node.left, peek.breadth--));
                if (peek.node.right != null)
                    queue.add(new Pair(peek.node.right, peek.breadth++));
            }
        }

        for (Entry<Integer, ArrayList<Integer>> pair : map.entrySet()) {
            ArrayList<Integer> array = pair.getValue();
            for (int i = 0; i < array.size(); i++) {
                System.out.print(array.get(i) + " ");
                al.add(array.get(i));
            }
            System.out.println();
        }

        return al;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, 8, null, null, 7, null, 9, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al = verticalOrder(root);

        for (Integer ele : al)
            System.out.print(ele + " ");
    }
}
