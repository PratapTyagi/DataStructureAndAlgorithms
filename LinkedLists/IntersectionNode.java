package LinkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class IntersectionNode {
    private static Node head1, head2;

    static Node push(Node head, int d) {
        if (head == null) {
            head = new Node(d);
            return head;
        }
        Node node = new Node(d);
        Node temp = head;
        node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static void printSet(HashSet<Node> set) {
        Iterator<Node> i = set.iterator();

        while (i.hasNext()) {
            Node val = (Node) i.next();
            System.out.print(val.data + " ");
        }
    }

    static Node intersection(Node head1, Node head2, HashSet<Node> set) {
        Node a = head1, b = head2;
        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }
        return a;
        // if (head1 == null) {
        // return head2;
        // }
        // if (head2 == null) {
        // return head1;
        // }

        // while (head1 != null && head2 != null) {
        // if (head1 == head2) {
        // return head1;
        // }
        // if (set.contains(head1)) {
        // return head1;
        // }
        // if (set.contains(head2)) {
        // return head2;
        // }
        // set.add(head1);
        // set.add(head2);
        // head1 = head1.next;
        // head2 = head2.next;
        // }

        // while (head1 != null) {
        // System.out.println("Second");
        // if (set.contains(head1)) {
        // return head1;
        // }
        // set.add(head1);
        // head1 = head1.next;
        // }

        // while (head2 != null) {
        // if (set.contains(head2)) {
        // return head2;
        // }
        // set.add(head2);
        // head2 = head2.next;
        // }

        // return null;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 5, 6 };
        int[] arr2 = new int[] { 3, 4 };
        for (int j = 0; j < arr1.length; j++)
            head1 = push(head1, arr1[j]);
        for (int j = 0; j < arr2.length; j++)
            head2 = push(head2, arr2[j]);
        head2.next.next = head1;

        HashSet<Node> set = new LinkedHashSet<>();
        Node res = intersection(head1, head2, set);
        System.out.println(res != null ? res.data : res);
    }
}
