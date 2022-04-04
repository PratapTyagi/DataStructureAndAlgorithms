public class MergeTwoSortedLists {
    private static LinkedListNode head1, head2;

    static LinkedListNode push(LinkedListNode head, int d) {
        if (head == null) {
            head = new LinkedListNode(d);
            return head;
        }
        LinkedListNode node = new LinkedListNode(d);
        LinkedListNode temp = head;
        node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    static void printList(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static LinkedListNode merge(LinkedListNode head1, LinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        LinkedListNode t1 = head1, t2 = head2;

        LinkedListNode res = null;
        if (head1.data < head2.data) {
            res = new LinkedListNode(head1.data);
            t1 = t1.next;
        } else {
            res = new LinkedListNode(head2.data);
            t2 = t2.next;
        }
        LinkedListNode pointer = res;
        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                pointer.next = new LinkedListNode(t1.data);
                t1 = t1.next;
            } else if (t1.data >= t2.data) {
                pointer.next = new LinkedListNode(t2.data);
                t2 = t2.next;
            }
            pointer = pointer.next;
            // printList(pointer);
            // System.out.println();
        }

        while (t1 != null) {
            pointer.next = new LinkedListNode(t1.data);
            t1 = t1.next;
        }
        while (t2 != null) {
            pointer.next = new LinkedListNode(t2.data);
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

        LinkedListNode res = merge(head1, head2);
        printList(res);
    }
}
