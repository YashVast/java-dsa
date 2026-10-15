class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class InsertionAtTail {
    public static Node convertArrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static Node insertAtTail(Node head, int element){
        if(head == null){
            return new Node(element,null);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        // Node newNode = new Node(element,null);
        // temp.next = newNode;
        temp.next = new Node(element,null);
        return head;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        int element = 111;
        Node head = convertArrayToLinkedList(arr);
        Node newHead = insertAtTail(head,element);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
