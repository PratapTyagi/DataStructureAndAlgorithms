public class ReverseListInGroupsSize {
    static LinkedListNode reverse(LinkedListNode head, int k) {
        if (head == null)
            return null;

        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = null;
        int count = 0;

        while (count++ < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = reverse(next, k);
        return prev;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        head = reverse(head, 2);

        i.printList(head);
    }
}
