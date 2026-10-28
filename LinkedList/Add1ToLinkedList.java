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
public class Add1ToLinkedList{
    public static Node convertArrayToLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    // BRUTE FORCE -->
    // TC: O(3n)
    // SC: O(1)
    // public static Node addOne(Node head){
    //     Node newHead = reverse(head);
    //     Node temp = newHead;
    //     int carry = 1;
    //     while(temp != null){
    //         temp.data = temp.data+carry;
    //         if(temp.data<10){
    //             carry = 0;
    //             break;
    //         }
    //         else{
    //             temp.data = 0;
    //             carry = 1;
    //         }
    //         temp = temp.next;
    //     }
    //     if(carry == 1){
    //         Node newNode = new Node(1);
    //         head = reverse(newHead);
    //         newNode.next = head;
    //         return newNode;
    //     }
    //     head = reverse(newHead);
    //     return head;
    // }
    // public static Node reverse(Node head){
    //     Node prev = null;
    //     Node current = head;
    //     while(current!=null){
    //         Node nextNode = current.next;
    //         current.next = prev;
    //         prev = current;
    //         current = nextNode;
    //     }
    //     return prev;
    // }


    // OPTIMAL -->
    // TC: O(n)
    // SC: O(n) --> Recursive Stack Space
    public static Node addOne(Node head){
        if(head == null){
            return head;
        }
        int carry = helper(head);
        if(carry == 1){
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    public static int helper(Node temp){
        if(temp == null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data = temp.data+carry;
        if(temp.data<10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }
    public static void main(String[] args){
        int[] arr = {1,5,9};
        // int[] arr = {9,9,9,9};
        Node head = convertArrayToLL(arr);
        Node newHead = addOne(head);
        while(newHead!=null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}