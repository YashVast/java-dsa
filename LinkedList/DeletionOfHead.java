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


public class DeletionOfHead{
    public static Node converArrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static Node removeHead(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        Node head = converArrayToLinkedList(arr);
        Node newHead = removeHead(head);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}