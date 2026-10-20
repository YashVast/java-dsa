import java.util.Stack;

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
public class ReverseLinkedList {
    public static Node convertArrayToLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length;i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        } 
        return head;
    }
    // BRUTE FORCE
    // TC: O(2n)
    // SC: O(n)
    // public static Node reverseLL(Node head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     Stack<Integer> stack = new Stack<>();
    //     Node temp = head;
    //     while(temp != null){
    //         stack.push(temp.data);
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     while(temp != null){
    //         temp.data = stack.pop();
    //         temp = temp.next;
    //     }
    //     return head;
    // }
    public static Node reverseLL(Node head){
        Node prev = null;
        Node current = head;
        while(current != null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr);
        Node newHead = reverseLL(head);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
