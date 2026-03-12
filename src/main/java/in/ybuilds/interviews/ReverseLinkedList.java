package in.ybuilds.interviews;

public class ReverseLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }
    }

    private Node reverse(Node head) {
        Node prev=null, curr=head, next=null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private void display(Node head) {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(12, new Node(23, new Node(34, new Node(45, new Node(56)))));
        ReverseLinkedList object = new ReverseLinkedList();
        Node reverse = object.reverse(head);
        object.display(reverse);
    }
}
