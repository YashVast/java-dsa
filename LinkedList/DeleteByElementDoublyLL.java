// Element could'nt be the first Node.

class Node{
    int data;
    Node next;
    Node back;

    Node(int data1,Node next1, Node back1){
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
public class DeleteByElementDoublyLL {
    public static Node converArrayToDoublyLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static Node removeHead(Node head){
        Node newHead = head.next;
        if(newHead != null){
            newHead.back = null;
        }
        head.next = null;
        return newHead;
    }
    public static Node removeTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node tail = temp.next;
        temp.next = null;
        tail.back = null;
        return head;
    }
    public static Node removeByElement(Node head,int element){
        if(head == null){
            return head;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == element){
                break;
            }
            temp = temp.next;
        }
        if(temp == null){
            return head;
        }
        Node prev = temp.back;
        Node front = temp.next;
        if(prev == null && front == null){
            return null;
        }
        else if(prev == null){
            return removeHead(head);
        }
        else if(front == null){
            return removeTail(head);
        }
        prev.next = front;
        front.back = prev;
        temp.next = null;
        temp.back = null;
        return head;
    }
    public static void main(String[] args){
        int[] arr = {2,3,5,7,9};
        int element = 2;
        Node head = converArrayToDoublyLL(arr);
        Node newHead = removeByElement(head,element);
        while(newHead != null){
            System.out.print(newHead.data+" ");
            newHead = newHead.next;
        }
    }
}
