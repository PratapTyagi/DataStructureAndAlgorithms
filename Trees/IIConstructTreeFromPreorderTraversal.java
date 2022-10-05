public class IIConstructTreeFromPreorderTraversal {
    static Node create(int n, int[] pre, char[] preLN, int[] preStartIndex) {
        if (preStartIndex[0] >= n)
            return null;

        Node root = new Node(pre[preStartIndex[0]]);

        if (preLN[preStartIndex[0]] == 'N') {
            preStartIndex[0]++;
            root.left = create(n, pre, preLN, preStartIndex);
            root.right = create(n, pre, preLN, preStartIndex);
        } else {
            preStartIndex[0]++;
            return root;
        }

        return root;
    }

    static Node constructTree(int n, int pre[], char preLN[]) {
        int preStartIndex[] = new int[] { 0 };
        return create(n, pre, preLN, preStartIndex);
    }

    public static void main(String[] args) {
        int N = 5;
        int pre[] = { 10, 30, 20, 5, 15 };
        char preLN[] = { 'N', 'N', 'L', 'L', 'L' }; // Leaf and non leaf nodes

        Implementation i = new Implementation();
        Node root = constructTree(N, pre, preLN);
        i.inOrder(root);
    }
}
