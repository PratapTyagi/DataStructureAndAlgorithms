package DoublyLinkedList;

public class InsertingIntoSortedDoublyLinkedList {
    static Node insert(Node head, int data) {
        if (head == null)
            return new Node(data, null, null);

        if (head.data >= data) {
            Node t = new Node(data, head, null);
            head.prev = t;
            return t;
        }

        Node prev = head, temp = head.next;

        while (temp != null) {
            if (temp.data >= data) {
                Node newNode = new Node(data, temp, prev);
                prev.next = newNode;
                temp.prev = newNode;
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = new Node(data, temp, prev);
        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 4, 7 };
        Node head = null;
        Implementation i = new Implementation();
        for (int j = 0; j < arr.length; j++)
            head = i.push(head, arr[j]);

        i.printList(head);
        System.out.println();
        head = insert(head, 5);
        i.printList(head);
    }
}
