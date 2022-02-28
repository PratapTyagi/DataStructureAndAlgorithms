package DoublyLinkedList;

import java.io.*;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }
}

public class Implementation {
    Node push(Node head, int data) {
        if (head == null) {
            return new Node(data, null, null);
        }
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(data, null, temp);
        return head;
    }

    void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter items in list: ");
        String[] d = br.readLine().split(" ");

        Node head = null;
        Implementation i = new Implementation();
        for (int j = 0; j < d.length; j++)
            head = i.push(head, Integer.parseInt(d[j]));

        i.printList(head);
    }
}
