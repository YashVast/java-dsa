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
    //BRUTE FORCE -->
    // TC: O(len)+O(len-n)
    // SC: O(1)
    // public static Node removeNthNode(Node head,int n){
    //     if(head == null || n<=0){
    //         return head;
    //     }
    //     int count = 0;
    //     Node temp = head;
    //     while(temp != null){
    //         count++;
    //         temp = temp.next;
    //     }
    //     if(n>count){
    //         return head;
    //     }
    //     if(count == n){
    //         Node newHead = head.next;
    //         return newHead;
    //     }
    //     int deleteNodeIndex = count-n-1;
    //     temp = head;
    //     while(temp != null){
    //         if(deleteNodeIndex == 0){
    //             break;
    //         }
    //         deleteNodeIndex--;
    //         temp = temp.next;
    //     }
    //     temp.next = temp.next.next;
    //     return head;
    // }

    //OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static Node removeNthNode(Node head,int n){
        if(head == null || n<=0){
            return head;
        }
        Node fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        Node slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
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