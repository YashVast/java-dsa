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
public class Add2Numbers {
    public static Node converArrayToLL(int[] arr){
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
    // TC: O(max(n1,n2))
    // SC: O(max(n1,n2))
    public static Node sumOfLL(Node head1,Node head2){
        Node t1 = head1;
        Node t2 = head2;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        int carry = 0;
        while(t1 != null || t2 != null){
            int sum = carry;
            if(t1 != null){
                sum += t1.data;
            }
            if(t2 != null){
                sum += t2.data;
            }
            Node newNode = new Node(sum%10);
            carry = sum/10;
            current.next = newNode;
            current = current.next;
            if(t1 != null){
                t1 = t1.next;
            }
            if(t2 != null){
                t2 = t2.next;
            }
        }
        if(carry != 0){
            Node newNode = new Node(carry);
            current.next = newNode;
        }
        return dummyNode.next;
    }
    public static void main(String[] args){
        int[] arr1 = {3,5};
        int[] arr2 = {4,5,9,9};
        Node head1 = converArrayToLL(arr1);
        Node head2 = converArrayToLL(arr2);
        Node newHead = sumOfLL(head1,head2);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
