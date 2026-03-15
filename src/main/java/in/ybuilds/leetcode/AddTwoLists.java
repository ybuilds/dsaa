package in.ybuilds.leetcode;

public class AddTwoLists {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode i=l1, j=l2;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        int carry=0, sum=0;

        ListNode resNode = res;

        while(i != null && j != null) {
            sum = carry + i.val + j.val;
            carry = sum / 10;
            res.next = new ListNode(sum%10);

            i = i.next;
            j = j.next;
            res = res.next;
        }

        while(i != null) {
            sum = carry + i.val;
            carry = sum / 10;
            res.next = new ListNode(sum%10);
            res = res.next;
            i = i.next;
        }

        while(j != null) {
            sum = carry + j.val;
            carry = sum / 10;
            res.next = new ListNode(sum%10);
            res = res.next;
            j = j.next;
        }

        if (carry > 0)
            res.next = new ListNode(carry);

        return resNode.next;
    }
}
