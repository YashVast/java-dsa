import java.util.Stack;

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
public class ReverseDoublyLL {
    public static Node converArrayToDoublyLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev= temp;
        }
        return head;
    }
    // BRUTE FORCE -->
    // TC: O(2n)
    // SC: O(n)
    // public static void main(String[] args){
    //     int[] arr = {5,4,3,2,1};
    //     Node head = converArrayToDoublyLL(arr);
    //     Node temp = head;
    //     Stack<Integer> stack = new Stack<>();
    //     while(temp != null){
    //         stack.push(temp.data);
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     while(temp != null){
    //         temp.data = stack.pop();
    //         temp = temp.next;
    //     } 
    //     while(head != null){
    //         System.out.print(head.data+" ");
    //         head = head.next;
    //     }
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static Node newHead(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node prev = null;
        Node current = head;
        while(current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        return prev.back;
    }
    public static void main(String[] args){
        int[] arr = {2,4,5,7,9};
        Node head = converArrayToDoublyLL(arr);
        Node newHead = newHead(head);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
