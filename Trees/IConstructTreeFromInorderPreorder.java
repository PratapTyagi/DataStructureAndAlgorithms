import java.util.HashMap;

public class IConstructTreeFromInorderPreorder {
    static Node construct(int preorder[], int preStart, int preEnd, int inorder[], int inStart, int inEnd,
            HashMap<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        Node root = new Node(preorder[preStart]);
        int mapRootLocation = map.get(preorder[preStart]);
        int numberOfChilderen = mapRootLocation - inStart;

        root.left = construct(preorder, preStart + 1, preStart + numberOfChilderen, inorder, inStart,
                mapRootLocation - 1, map);
        root.right = construct(preorder, preStart + numberOfChilderen + 1, preEnd, inorder, mapRootLocation + 1, inEnd,
                map);

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return construct(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }

    static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int N = 4;
        int inorder[] = new int[] { 1, 6, 8, 7 };
        int preorder[] = new int[] { 1, 6, 7, 8 };

        Node root = buildTree(inorder, preorder, N);

        postOrder(root);
    }
}
