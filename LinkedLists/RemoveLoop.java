public class RemoveLoop {

    private static boolean detectCycle(LinkedListNode head) {
        if (head == null || head.next == null)
            return false;

        LinkedListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static void removeLoop(LinkedListNode head, LinkedListImplementation i) {
        if (!detectCycle(head))
            return;

        // First point when slow fast meet
        LinkedListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        // if the cycle is present on head itself
        if (fast == head) {
            while (slow.next != head)
                slow = slow.next;
            slow.next = null;
            return;
        }

        fast = head; // fast to 1st node in linked list

        // check for the cycle point
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = null;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;

        head.next.next.next = head;
        removeLoop(head, i);

        i.printList(head);
    }
}
