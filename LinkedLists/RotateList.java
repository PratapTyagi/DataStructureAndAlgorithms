public class RotateList {
    static LinkedListNode rotate(LinkedListNode head, int k) {
        LinkedListNode temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = head;
        LinkedListNode end = head;
        while (k-- > 0) {
            end = head;
            head = head.next;
        }

        end.next = null;
        return head;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        head = rotate(head, 2);

        i.printList(head);
    }
}
