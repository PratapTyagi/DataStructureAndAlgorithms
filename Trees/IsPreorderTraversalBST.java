import java.util.ArrayList;
import java.util.Stack;

public class IsPreorderTraversalBST {
    static int isTrue(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek())
                root = stack.pop();
            if (root > arr[i])
                return 0;
            stack.push(arr[i]);
        }

        return 1;
    }

    static void preOrder(Node root, ArrayList<Integer> al) {
        if (root == null)
            return;

        al.add(root.data);
        preOrder(root.left, al);
        preOrder(root.right, al);
    }

    public static void main(String[] args) {
        Implementation i = new Implementation();
        Integer[] arr = { 1, 2, null, null, 3, null, null };

        Node root = new Node(arr[0]);
        i.createBinaryTree(arr, root);
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        preOrder(root, al1);

        int[] preOrder = new int[al1.size()];

        System.out.print("Input: " + "\n" + preOrder.length + "\n");
        for (int j = 0; j < preOrder.length; j++) {
            preOrder[j] = al1.get(j);
            System.out.print(preOrder[j] + " ");
        }
        System.out.print("\n" + "Output: " + "\n");
        int isTrue = isTrue(preOrder);
        System.out.println(isTrue == 1 ? true : false);
    }
}