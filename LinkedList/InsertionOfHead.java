class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class InsertionOfHead {
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
    public static Node insertHead(Node head, int element){
        Node temp = new Node(element,head);
        return temp;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        int element = 111;
        Node head = convertArrayToLinkedList(arr);
        Node newHead = insertHead(head,element);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
