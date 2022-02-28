package LinkedLists;

public class PrintReverse {
    static void reverse(Node head) {
        if (head == null)
            return;
        reverse(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        Implementation i = new Implementation();

        int[] arr = new int[] { 3, 3, 4, 1, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        Node head = i.head;
        reverse(head);
    }
}
