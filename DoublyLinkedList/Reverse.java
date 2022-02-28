package DoublyLinkedList;

public class Reverse {
    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null, current = head, next = null;

        while (current != null) {
            next = current.next;
            current.next = current.prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2 };
        Node head = null;
        Implementation i = new Implementation();
        for (int j = 0; j < arr.length; j++)
            head = i.push(head, arr[j]);

        i.printList(head);
        System.out.println();
        head = reverse(head);
        i.printList(head);
    }
}
