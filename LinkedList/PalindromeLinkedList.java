

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
public class PalindromeLinkedList{
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
    // SC: O(n)
    // public static boolean isLLPalindrome(Node head){
    //     if(head == null || head.next == null){
    //         return true;
    //     }
    //     Stack<Integer> stack = new Stack<>();
    //     Node temp = head;
    //     while(temp != null){
    //         stack.push(temp.data);
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     while(temp != null){
    //         if(temp.data != stack.pop()){
    //             return false;
    //         }
    //         temp = temp.next;
    //     }
    //     return true;
    // }

    //OPTIMAL -->
    // TC: O(n)
    // SC: O(1)
    public static boolean isLLPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = reverse(slow.next);
        Node first = head;
        Node second = secondHalf;
        while(second!=null){
            if(first.data!=second.data){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }
    public static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        while(current!=null){
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,2,1};
        Node head = convertArrayToLL(arr);
        boolean isPalindrome = isLLPalindrome(head);
        System.out.println(isPalindrome);
    }
}