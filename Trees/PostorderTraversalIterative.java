import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostorderTraversalIterative {
    static ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node peek = stack.pop();

            al.add(peek.data);
            if (peek.left != null)
                stack.push(peek.left);
            if (peek.right != null)
                stack.push(peek.right);
        }

        Collections.reverse(al);

        return al;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al = postOrder(root);

        for (Integer ele : al)
            System.out.print(ele + " ");
    }
}
