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
public class SortArrayZerosOnesTwos{
    public static Node convertArrayToLL(int[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    // BRUTE FORCE -->
    // TC: O(2n)
    // SC: O(1)
    // public static Node sortZeroOnesTwos(Node head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     int count0 = 0;
    //     int count1 = 0;
    //     int count2 = 0;
    //     Node temp = head;
    //     while(temp != null){
    //         if(temp.data == 0){
    //             count0++;
    //         }
    //         else if(temp.data == 1){
    //             count1++;
    //         }
    //         else{
    //             count2++;
    //         }
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     while(temp != null){
    //         for(int i=0; i<count0; i++){
    //             temp.data = 0;
    //             temp = temp.next;
    //         }
    //         for(int i=0; i<count1; i++){
    //             temp.data = 1;
    //             temp = temp.next;
    //         }
    //         for(int i=0; i<count2; i++){
    //             temp.data = 2;
    //             temp = temp.next;
    //         }
    //     }
    //     return head;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static Node sortZeroOnesTwos(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;

        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        Node newhead = zeroHead.next;
        return newhead;
    }
    public static void main(String[] args){
        int[] arr = {1,0,1,2,0,2,1};
        Node head = convertArrayToLL(arr);
        Node newHead = sortZeroOnesTwos(head);
        while(newHead != null){
            System.err.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}