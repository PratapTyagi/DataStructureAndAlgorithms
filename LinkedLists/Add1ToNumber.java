public class Add1ToNumber {
    static LinkedListNode reverse(LinkedListNode root) {
        LinkedListNode prev = null, curr = root, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static LinkedListNode addOne(LinkedListNode root) {
        LinkedListNode head = reverse(root);

        LinkedListNode temp = head;
        int carry = 1;
        LinkedListNode prev = null;

        while (temp != null) {
            int data = temp.data + carry;
            temp.data = data % 10;
            carry = data / 10;
            prev = temp;
            temp = temp.next;
        }

        if (carry != 0)
            prev.next = new LinkedListNode(carry);

        return reverse(head);
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 0, 5, 6, 8, 9 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        LinkedListNode root = addOne(head);

        i.printList(root);
    }
}
