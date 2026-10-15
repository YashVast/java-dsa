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

public class InsertBeforeValue {
    public static Node convertArrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    public static Node insertByValue(Node head,int k,int element){
        if(head == null){
            return head;
        }
        if(head.data == k){
            new Node(element,head);
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == k){
                prev.next = new Node(element,temp);
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        throw new IllegalArgumentException("value of k is not present");
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        int k = 5;
        int element = 111;
        Node head = convertArrayToLinkedList(arr);
        Node newHead = insertByValue(head,k,element);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
