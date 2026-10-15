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

public class InsertionByPosition {
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
    public static Node insertAtKPosition(Node head,int element,int k){
        if(head == null){
            if(k == 1){
                return new Node(element,null);
            }
            else{
                throw new IllegalArgumentException("value of k is not valid");
            }
        }
        if(k == 1){
            return new Node(element,head);
        }
        Node temp = head;
        Node prev = null;
        int count = 0;
        while(temp != null){
            count++;
            if(count == k){
                prev.next = new Node(element,temp);
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        if(count+1 == k){
            prev.next = new Node(element,null);
            return head;
        }
        throw new  IllegalArgumentException("value of k is not valid");
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        int element = 111;
        int k = 3;
        Node head = converArrayToLinkedList(arr);
        Node newHead = insertAtKPosition(head,element,k);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
