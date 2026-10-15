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

public class DeletionOfTail {
    public static Node converArrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover= temp;
        }
        return head;
    }
    public static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null; 
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        Node head = converArrayToLinkedList(arr);
        head = deleteTail(head);
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
