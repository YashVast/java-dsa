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
public class RemoveNthNodeFromEnd{
    public static Node covertArrayToLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length; i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static Node removeNthNode(Node head,int n){
        
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int n = 2;
        Node head = covertArrayToLL(arr);
        Node newHead = removeNthNode(head,n);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}