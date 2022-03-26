import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {
    static boolean isLeaf(Node curr) {
        if (curr.left == null && curr.right == null)
            return true;

        return false;
    }

    static void leftBoundry(Node root, ArrayList<Integer> ans) {
        Node temp = root;
        while (temp != null) {
            if (isLeaf(temp) == false)
                ans.add(temp.data);
            if (temp.left != null)
                temp = temp.left;
            else
                temp = temp.right;
        }
    }

    static void addLeaf(Node root, ArrayList<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }

        if (root.left != null)
            addLeaf(root.left, ans);
        if (root.right != null)
            addLeaf(root.right, ans);
    }

    static void rightBoundry(Node root, ArrayList<Integer> ans) {
        Node temp = root;
        Stack<Integer> s = new Stack<>();

        while (temp != null) {
            if (isLeaf(temp) == false)
                s.push(temp.data);
            if (temp.right != null)
                temp = temp.right;
            else
                temp = temp.left;
        }

        while (!s.isEmpty())
            ans.add(s.pop());
    }

    static ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Node temp = node;

        if (temp == null)
            return ans;

        if (isLeaf(temp) == false && temp.left == null)
            ans.add(temp.data);

        // Left boundry
        if (temp.left != null)
            leftBoundry(temp, ans);

        // Leaf nodes
        addLeaf(node, ans);

        // Right boundry
        if (node.right != null)
            rightBoundry(node.right, ans);

        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 4, null, null, 5, 8, null, null, 9, null, null, 3, 6, null, null, 7, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al = boundary(root);

        for (Integer ele : al)
            System.out.print(ele + " ");
    }
}
