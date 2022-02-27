package LinkedLists;

public class BinaryNumberListToDecimal {
    static int toDecimal(Node head) {
        if (head == null) {
            return -1;
        }
        StringBuilder str = new StringBuilder();
        while (head != null) {
            str.append(head.data);
            head = head.next;
        }

        return Integer.parseInt(str.toString(), 2);
    }

    public static void main(String[] args) {
        Implementation i = new Implementation();

        int[] arr = new int[] { 0, 0, 1, 1, 1 };
        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        Node head = i.head;
        int middle = toDecimal(head);
        System.out.println(middle);
    }
}
