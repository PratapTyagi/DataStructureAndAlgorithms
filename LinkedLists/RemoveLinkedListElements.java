public class RemoveLinkedListElements {
    static LinkedListNode remove(LinkedListNode head, int value) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode temp = head;
        while (temp != null && temp.data == value) {
            temp = temp.next;
        }
        head = temp;
        LinkedListNode prev = temp;
        while (temp != null) {
            if (value == temp.data) {
                LinkedListNode t = temp.next;
                temp.next = null;
                prev.next = t;
                temp = t;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 1, 3, 4, 3, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        head = remove(head, 1);

        i.printList(head);
    }

}