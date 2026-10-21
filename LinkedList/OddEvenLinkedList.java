
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
public class OddEvenLinkedList {
    public static Node convertArrayToLL(int[] arr){
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
    // BRUTE FORCE -->
    // TC: O(n/2+n/2+n) = O(2n)
    // SC: O(n)
    // public static Node oddEvenLL(Node head){
    //     if(head == null || head.next == null){
    //         return head;
    //     }
    //     List<Integer> list = new ArrayList<>();
    //     Node temp = head;
    //     while(temp != null){
    //         list.add(temp.data);
    //         if(temp.next == null){
    //             break;
    //         }
    //         temp = temp.next.next;
    //     }
    //     temp = head.next;
    //     while(temp != null){
    //         list.add(temp.data);
    //         if(temp.next == null){
    //             break;
    //         }
    //         temp = temp.next.next;
    //     }
    //     temp = head;
    //     for(int i=0; i<list.size(); i++){
    //         temp.data = list.get(i);
    //         temp = temp.next;
    //     }
    //     return head;
    // }

    // OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static Node oddEvenLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        } 
        odd.next = evenHead;
        return head;
    }
    public static void main(String[] args){
        int[] arr = {1,3,4,2,5,6};
        Node head = convertArrayToLL(arr);
        Node newHead = oddEvenLL(head);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
