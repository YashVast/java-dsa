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
public class MiddleOfLinkedList{
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
    // TC: O(2n)
    // SC: O(1)
    // public static Node middleOfLL(Node head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     int count = 0;
    //     Node temp = head;
    //     while(temp != null){
    //         count++;
    //         temp = temp.next;
    //     }
    //     int middle = count/2+1;
    //     middle = middle-1;
    //     temp = head;
    //     while(temp != null){
    //         if(middle == 0){
    //             break;
    //         }
    //         middle--;
    //         temp = temp.next;
    //     }
    //     return temp;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static Node middleOfLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Node head = convertArrayToLL(arr);
        Node middle = middleOfLL(head);
        System.out.println(middle.data);
    }
}