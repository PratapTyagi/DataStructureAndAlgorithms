public class MergeListsAlternatingly {
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

    static void mergeAlt(LinkedListNode h1, LinkedListNode h2) {
        LinkedListNode curr1 = h1;
        LinkedListNode curr2 = h2;
        while (curr2 != null && curr1 != null) {
            LinkedListNode temp1 = curr1.next;
            LinkedListNode temp2 = curr2.next;
            curr1.next = curr2;
            curr2.next = temp1;
            curr1 = temp1;
            curr2 = temp2;
        }
        h2 = curr2;
        while (h1 != null) {
            System.out.print(h1.data + " ");
            h1 = h1.next;
        }
        System.out.println();
        while (h2 != null) {
            System.out.print(h2.data + " ");
            h2 = h2.next;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr1 = new int[] { 1, 2, 5, 6 };
        int[] arr2 = new int[] { 0, 3, 7 };
        for (int j = 0; j < arr1.length; j++)
            head1 = push(head1, arr1[j]);
        for (int j = 0; j < arr2.length; j++)
            head2 = push(head2, arr2[j]);

        mergeAlt(head1, head2);
    }
}
