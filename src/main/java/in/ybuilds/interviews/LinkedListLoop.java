package in.ybuilds.interviews;

import java.util.Scanner;

public class LinkedListLoop {
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

    private boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Node slow=head, fast=head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    private void removeCycle(Node head) {
        if (head == null)
            return;

        Node slow=head, fast=head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null)
            return;

        slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        while(fast.next != slow)
            fast = fast.next;

        fast.next = null;
    }

    private void detectCycle(Node head) {
        if (head == null)
            return;

        Node slow=head, fast=head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        if (fast == null || fast.next == null)
            return;

        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println(slow);
    }

    public static void main(String[] args) {
        Node node = new Node(3, new Node(2, new Node(0, new Node(-4))));
    }
}
