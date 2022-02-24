package Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestValueInEachLevel {
    static void largestValue(Node root, int level, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(level) && map.get(level) < root.data) {
            map.put(level, root.data);
        } else if (!map.containsKey(level)) {
            map.put(level, root.data);
        }

        largestValue(root.left, level + 1, map);
        largestValue(root.right, level + 1, map);
    }

    public static void main(String[] args) {
        // Integer[] arr = { 1, 1, 1, 1, 1, null, 1, 1, 1, 1, 1 };
        Integer[] arr = { 1, 2, null, null, 3, null, null };

        Node root = new Node(arr[0]);
        Implementation i = new Implementation();
        i.createBinaryTree(arr, root);

        i.inOrder(root);
        HashMap<Integer, Integer> map = new HashMap<>();
        largestValue(root, 0, map);

        System.out.println();
        ArrayList<Integer> al = new ArrayList<>();

        for (int j = 0; map.containsKey(j); j++) {
            al.add(map.get(j));
        }
    }
}
