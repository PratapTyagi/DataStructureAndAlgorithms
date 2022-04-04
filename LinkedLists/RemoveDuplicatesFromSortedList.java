public class RemoveDuplicatesFromSortedList {
    static LinkedListNode remove(LinkedListNode head) {
        if (head == null) {
            return head;
        }

        LinkedListNode temp = head;
        LinkedListNode prev = null;
        while (temp != null) {
            if (prev != null && temp.data == prev.data) {
                LinkedListNode t = temp.next;
                prev.next = temp.next;
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

        int[] arr = new int[] { 3, 3, 4, 1, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        head = remove(head);

        i.printList(head);
    }
}