package LinkedLists;

public class MergeTwoSortedLists {
    private static Node head1, head2;

    static Node push(Node head, int d) {
        if (head == null) {
            head = new Node(d);
            return head;
        }
        Node node = new Node(d);
        Node temp = head;
        node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node t1 = head1, t2 = head2;

        Node res = null;
        if (head1.data < head2.data) {
            res = new Node(head1.data);
            t1 = t1.next;
        } else {
            res = new Node(head2.data);
            t2 = t2.next;
        }
        Node pointer = res;
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                pointer.next = new Node(t1.data);
                t1 = t1.next;
            } else if (t1.data >= t2.data) {
                pointer.next = new Node(t2.data);
                t2 = t2.next;
            }
            pointer = pointer.next;
            // printList(pointer);
            // System.out.println();
        }

        while (t1 != null) {
            pointer.next = new Node(t1.data);
            t1 = t1.next;
        }
        while (t2 != null) {
            pointer.next = new Node(t2.data);
            t2 = t2.next;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 5, 6 };
        int[] arr2 = new int[] { 0, 3, 7 };
        for (int j = 0; j < arr1.length; j++)
            head1 = push(head1, arr1[j]);
        for (int j = 0; j < arr2.length; j++)
            head2 = push(head2, arr2[j]);

        Node res = merge(head1, head2);
        printList(res);
    }
}
