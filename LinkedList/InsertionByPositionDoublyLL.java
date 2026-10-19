
class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}

public class InsertionByPositionDoublyLL {

    public static Node converArrayToDoublyLL(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static Node insertAtHead(Node head, int element) {
        Node newHead = new Node(element, head, null);

        if (head != null) {
            head.back = newHead;
        }

        return newHead;
    }

    public static Node insertAtTail(Node head, int element) {
        if (head == null) {
            return new Node(element);
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        Node newNode = new Node(element, null, temp);
        temp.next = newNode;

        return head;
    }

    public static Node insertAtKthPosition(Node head, int k, int element) {
        if (k <= 0) {
            return head;
        }

        // Insert at the head
        if (k == 1) {
            return insertAtHead(head, element);
        }

        // Find the node currently at position k
        Node temp = head;
        int count = 1;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // Insert at the end (position n + 1)
        if (temp == null) {
            if (count == k) {
                return insertAtTail(head, element);
            }
            return head;
        }

        Node prev = temp.back;

        // Insert before temp
        Node newNode = new Node(element, temp, prev);
        prev.next = newNode;
        temp.back = newNode;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 9};
        int k = 5;
        int element = 111;

        Node head = converArrayToDoublyLL(arr);
        Node newHead = insertAtKthPosition(head, k, element);

        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}
