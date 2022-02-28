package LinkedLists;

public class RemoveDuplicatesFromSortedList {
    static Node remove(Node head) {
        if (head == null) {
            return head;
        }

        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (prev != null && temp.data == prev.data) {
                Node t = temp.next;
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
        Implementation i = new Implementation();

        int[] arr = new int[] { 3, 3, 4, 1, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        Node head = i.head;
        head = remove(head);

        i.printList(head);
    }
}