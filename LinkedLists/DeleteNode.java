package LinkedLists;

public class DeleteNode {
    static Node delete(Node head, int data) {
        if (head == null) {
            return null;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = temp;

        while (temp != null) {
            if (temp.data == data) {
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Implementation i = new Implementation();

        int[] arr = new int[] { 0, 5, 6, 8, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        Node head = i.head;
        head = delete(head, 1);

        i.printList(head);
    }
}
