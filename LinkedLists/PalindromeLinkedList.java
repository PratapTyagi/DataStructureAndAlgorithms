public class PalindromeLinkedList {
    static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode slow = head, fast = head, prev = null;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        prev = slow;
        slow = slow.next;
        prev.next = null;

        while (slow != null) {
            LinkedListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        fast = head;
        slow = prev;

        while (fast != null) {
            if (fast.data != slow.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();

        int[] arr = new int[] { 1, 5, 6, 8, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;
        boolean ans = isPalindrome(head);

        System.out.println(ans);
    }
}
