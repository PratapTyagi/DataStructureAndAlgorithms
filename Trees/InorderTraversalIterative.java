import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalIterative {
    static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<>();

        Node temp = root;

        while (true) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                if (stack.isEmpty())
                    break;
                temp = stack.pop();

                al.add(temp.data);
                temp = temp.right;
            }
        }

        return al;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al = inOrder(root);

        for (Integer ele : al)
            System.out.print(ele + " ");
    }
}
