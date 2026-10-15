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

public class DeleteByElement {
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
    public static Node deleteByElement(Node head, int k){
        if(head == null){
            return head;
        }
        if(head.data == k){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;

        while(temp != null){
            if(temp.data == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        int k = 4;
        Node head = convertArrayToLinkedList(arr);
        Node newHead = deleteByElement(head,k);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
