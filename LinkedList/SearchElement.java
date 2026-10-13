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

// TC: O(n)
public class SearchElement{
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
    public static boolean checkElement(Node head, int element){
        Node temp = head;
        while(temp != null){
            if(temp.data == element){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {2,5,8,7};
        int element = 51;
        Node head = converArrayToLinkedList(arr);
        boolean checkIfPresent = checkElement(head,element);
        System.out.println(checkIfPresent);
    }
}