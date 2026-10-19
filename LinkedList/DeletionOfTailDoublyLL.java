class Node{
    int data;
    Node next;
    Node back;
    Node(int data1,Node next1,Node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class DeletionOfTailDoublyLL {
    public static Node convertArrayToDoublyLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node tail = temp.next;
        temp.next = null;
        tail.back = null;
        return head;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        Node head = convertArrayToDoublyLL(arr);
        Node newHead = removeTail(head);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
