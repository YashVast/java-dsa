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

public class DeleteByPosition {
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
    public static Node removeKthNode(Node head,int k){
        if(head == null){
            return head;
        }
        if(k==1){
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            count++;
            if(count == k){
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
        int k = 3;
        Node head = converArrayToLinkedList(arr);
        Node newData = removeKthNode(head,k);
        while(newData != null){
            System.out.print(newData.data + " ");
            newData = newData.next;
        }
    }
}
