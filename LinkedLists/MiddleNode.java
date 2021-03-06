public class MiddleNode {
    static int mid(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        int res = -1;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow != null) {
            res = slow.data;
        }
        return res;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 0, 5, 6, 8, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        int middle = mid(head);
        System.out.println(middle);
    }
}
