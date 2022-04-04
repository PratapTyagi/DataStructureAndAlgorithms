public class DeleteNode {
    static LinkedListNode delete(LinkedListNode head, int data) {
        if (head == null) {
            return null;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }

        LinkedListNode temp = head;
        LinkedListNode prev = temp;

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
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 0, 5, 6, 8, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        head = delete(head, 1);

        i.printList(head);
    }
}
