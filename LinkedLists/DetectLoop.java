package LinkedLists;

public class DetectLoop {

    static void detectLoop(Node head) {
        if (head == null) {
            System.out.println("No loop found.");
        }

        Node slow = head;
        Node fast = slow.next;
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
        Implementation i = new Implementation();
        i.push(3);
        i.push(5);
        i.push(1);
        Node head = i.head;
        head.next.next.next = head;

        detectLoop(head);
    }
}
