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

public class LengthOfLinkedList{
    public static void main(String[] args){
        int[] arr = {2,5,8,7};
        Node head = convertArrayToLinkedList(arr);
        int count = countElements(head);
        System.out.println(count);
    }
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
    public static int countElements(Node head){
        int count = 0;
        Node temp = head; 
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}