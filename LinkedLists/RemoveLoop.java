public class RemoveLoop {
    public static void removeLoop(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        if (slow == head) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }

        else if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;

        head.next.next.next = head;
        removeLoop(head);

        i.printList(head);
    }
}
