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
public class InsertionAtTailDoublyLL {
    public static Node converArrayToDoublyLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static Node insertAtTail(Node head,int k){
        if(head == null){
            return new Node(k,null,null);
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(k,null,temp);
        return head; 
    }
    public static void main(String[] args){
        int[] arr = {2,3,5,7,9};
        int k = 111;
        Node head = converArrayToDoublyLL(arr);
        Node newHead = insertAtTail(head,k);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
