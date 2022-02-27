package LinkedLists;

import java.io.*;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Implementation {
    Node head;

    void push(int d) {
        if (head == null) {
            head = new Node(d);
            return;
        }

        Node node = new Node(d);
        Node temp = head;
        node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
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

        Implementation list = new Implementation();

        System.out.println("Enter items in list: ");
        String[] d = br.readLine().split(" ");

        for (int i = 0; i < d.length; i++)
            list.push(Integer.parseInt(d[i]));

        list.printList(list.head);
    }
}