public class ReverseLinkedList {

    static LinkedListNode reverse(LinkedListNode head) {
        if (head == null) {
            return head;
        }

        LinkedListNode next = null;
        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;
    }

    public static void main(String[] args) throws Exception {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        head = reverse(head);

        i.printList(head);
    }
}
