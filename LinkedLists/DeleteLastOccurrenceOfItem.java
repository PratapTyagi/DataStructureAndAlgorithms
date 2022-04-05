public class DeleteLastOccurrenceOfItem {
    static void delete(LinkedListNode root, int data) {
        LinkedListNode ans = null, head = root;
        while (head != null) {
            if (head.data == data)
                ans = head;
            head = head.next;
        }

        if (ans != null && ans.next == null) {
            head = root;
            while (head.next != ans)
                head = head.next;
            head.next = null;
        } else {
            ans.data = ans.next.data;
            ans.next = ans.next.next;
        }

    }

    public static void main(String[] args) {

        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        delete(head, 1);

        i.printList(head);
    }
}
