public class TrieImplementation {
    private static class Node {
        Node links[];
        boolean flag;

        Node() {
            links = new Node[26];
            flag = false;
        }

        boolean containsChar(char c) {
            return links[c - 'a'] != null;
        }

        void put(char c, Node node) {
            links[c - 'a'] = node;
        }

        Node getNext(char c) {
            return links[c - 'a'];
        }

        Node getNext(int idx) {
            return links[idx];
        }

        void setEnd() {
            flag = false;
        }

        boolean isEnd() {
            return flag;
        }
    };

    private Node root;
    private int idx;

    TrieImplementation() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsChar(c))
                node.put(c, new Node());
            node = node.getNext(c);
        }

        node.setEnd();
    }

    boolean search(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsChar(c))
                return false;
            node = node.getNext(c);
        }

        return node.isEnd();
    }

    boolean startsWith(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsChar(c))
                return false;
            node = node.getNext(c);
        }

        return true;
    }

    // LCP(Longest Common Prefix)
    int countChildren(Node node) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (node.links[i] != null) {
                count++;
                idx = i;
            }
        }

        return count;
    }

    String walkTrie() {
        StringBuilder ans = new StringBuilder();
        idx = 0;
        Node node = root;

        while (countChildren(node) == 1 && !node.isEnd()) {
            node = node.getNext(idx);
            ans.append((char) ('a' + idx));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String arr[] = new String[] { "geeksforgeeks", "geeks", "geek",
                "geezer" };

        TrieImplementation t = new TrieImplementation();
        for (int i = 0; i < arr.length; i++)
            t.insert(arr[i]);

        String ans = t.walkTrie();
        System.out.println(ans);

    }
}
