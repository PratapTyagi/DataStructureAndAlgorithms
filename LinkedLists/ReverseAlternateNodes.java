/**
 * ReverseAlternateNodes
 */
public class ReverseAlternateNodes {
    static LinkedListNode reverse(LinkedListNode root) {
        if (root == null || root.next == null)
            return root;

        LinkedListNode prev = null, next = null, curr = root;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void rearrange(LinkedListNode root) {
        if (root == null || root.next == null)
            return;

        LinkedListNode even = root, oddHead = root.next, odd = root.next;

        while (odd != null && odd.next != null) {
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }

        oddHead = reverse(oddHead);
        even.next = oddHead;
        return;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        rearrange(head);

        i.printList(head);
    }
}