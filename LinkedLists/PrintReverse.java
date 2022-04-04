public class PrintReverse {
    static void reverse(LinkedListNode head) {
        if (head == null)
            return;
        reverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 3, 3, 4, 1, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        reverse(head);
    }
}
