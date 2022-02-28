package LinkedLists;

public class RemoveLinkedListElements {
    static Node remove(Node head, int value) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        while (temp != null && temp.data == value) {
            temp = temp.next;
        }
        head = temp;
        Node prev = temp;
        while (temp != null) {
            if (value == temp.data) {
                Node t = temp.next;
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
        Implementation i = new Implementation();

        int[] arr = new int[] { 1, 3, 4, 3, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        Node head = i.head;
        head = remove(head, 1);

        i.printList(head);
    }

}