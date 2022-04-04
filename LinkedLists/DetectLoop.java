public class DetectLoop {

    static void detectLoop(LinkedListNode head) {
        if (head == null) {
            System.out.println("No loop found.");
        }

        LinkedListNode slow = head;
        LinkedListNode fast = slow.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Found loop on: " + slow.data);
                break;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();
        i.push(3);
        i.push(5);
        i.push(1);
        LinkedListNode head = i.head;
        head.next.next.next = head;

        detectLoop(head);
    }
}
