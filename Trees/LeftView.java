import java.util.ArrayList;
import java.util.HashMap;

public class LeftView {
    static void solve(Node root, int count, HashMap<Integer, Integer> map, ArrayList<Integer> ans) {
        if (root == null)
            return;

        if (!map.containsKey(count)) {
            map.put(count, root.data);
            ans.add(root.data);
        }

        solve(root.left, count + 1, map, ans);
        solve(root.right, count + 1, map, ans);
    }

    static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        solve(root, 0, map, ans);
        return ans;
    }

    public static void main(String[] args) {
        Implementation i = new Implementation();
        Integer[] arr = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, 5 };

        Node root = new Node(arr[0]);
        i.createBinaryTree(arr, root);

        i.inOrder(root);
        System.out.println();
        ArrayList<Integer> ans = leftView(root);

        for (Integer e : ans)
            System.out.print(e + " ");
    }
}
