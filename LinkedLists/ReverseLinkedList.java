package LinkedLists;

public class ReverseLinkedList {

    static Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node next = null;
        Node curr = head;
        Node prev = null;

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
        Implementation i = new Implementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        Node head = i.head;
        head = reverse(head);

        i.printList(head);
    }
}
