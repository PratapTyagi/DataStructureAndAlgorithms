import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class VIILevelOrderTraversal {
    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        while (!queue.isEmpty()) {
            // rpa -> remove, process, add
            Node peek = queue.poll();

            al.add(peek.data);
            if (peek.left != null)
                queue.add(peek.left);
            if (peek.right != null)
                queue.add(peek.right);
        }

        return al;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al = levelOrder(root);

        for (Integer ele : al)
            System.out.print(ele + " ");
    }
}
