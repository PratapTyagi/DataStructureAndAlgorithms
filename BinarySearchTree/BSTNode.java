class BSTNode {
    BSTNode left;
    BSTNode right;
    int data;

    public BSTNode(int data, BSTNode lefNode, BSTNode rightNode) {
        this.data = data;
        left = lefNode;
        right = rightNode;
    }
}