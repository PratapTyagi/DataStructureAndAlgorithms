import java.io.*;

class LinkedListNode {
    LinkedListNode next;
    int data;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListImplementation {
    LinkedListNode head;

    void push(int d) {
        if (head == null) {
            head = new LinkedListNode(d);
            return;
        }

        LinkedListNode node = new LinkedListNode(d);
        LinkedListNode temp = head;
        node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    void insertHead(int d) {
        if (head == null) {
            head = new LinkedListNode(d);
            return;
        }
        LinkedListNode temp = new LinkedListNode(d);
        temp.next = head;
        head = temp;
    }

    void printList(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedListImplementation list = new LinkedListImplementation();

        System.out.println("Enter items in list: ");
        String[] d = br.readLine().split(" ");

        for (int i = 0; i < d.length; i++)
            list.push(Integer.parseInt(d[i]));

        list.printList(list.head);
    }
}