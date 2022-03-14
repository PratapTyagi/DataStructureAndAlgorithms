import java.util.*;

/*
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
*/

public class ZigZagTraversal {
    static void zigZag(Node root) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int flag = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> inner = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                inner.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag % 2 != 0) {
                Collections.reverse(inner);
            }
            for (int i = 0; i < inner.size(); i++) {
                al.add(inner.get(i));
            }
            flag++;
        }

        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 7, 9, 8, 10, null, null, 9, null, null, 8, null, null, 7, 6, null, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);

        i.inOrder(root);
        System.out.println();
        zigZag(root);
    }
}
