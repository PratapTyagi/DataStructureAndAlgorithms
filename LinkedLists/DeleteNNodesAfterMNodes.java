public class DeleteNNodesAfterMNodes {
    static void linkdelete(LinkedListNode head, int M, int N) {
        int count = 0;
        while (head != null) {
            count++;
            int d = N;
            if (count == M) {
                while (d-- > 0) {
                    if (head.next == null)
                        return;
                    head.next = head.next.next;
                }
                count = 0;
            }

            head = head.next;
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 9, 5, 1, 8, 6, 1, 3 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        linkdelete(head, 2, 1);

        i.printList(head);
    }
}
