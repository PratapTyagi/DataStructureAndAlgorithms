import java.util.HashMap;

public class DeleteElementsInListWhoseSumEqualsZero {
    static LinkedListNode delete(LinkedListNode root, LinkedListImplementation i) {
        HashMap<Integer, LinkedListNode> map = new HashMap<>();
        LinkedListNode head = root;
        LinkedListNode ans = new LinkedListNode(0);
        ans.next = head;
        map.put(0, ans);
        int sum = 0;

        while (head != null) {
            sum += head.data;

            if (map.containsKey(sum)) {
                LinkedListNode temp = map.get(sum).next;
                int currentSum = sum;

                while (temp != head) {
                    currentSum += temp.data;
                    map.remove(currentSum);
                    temp = temp.next;
                }
                map.get(sum).next = head.next;
            } else
                map.put(sum, head);

            head = head.next;
        }

        return ans.next;
    }

    public static void main(String[] args) {
        LinkedListImplementation i = new LinkedListImplementation();
        int[] arr = new int[] { -1, 1, 0, 1 };

        for (int j = 0; j < arr.length; j++)
            i.push(arr[j]);

        LinkedListNode head = i.head;

        LinkedListNode res = delete(head, i);
        i.printList(res);
    }
}