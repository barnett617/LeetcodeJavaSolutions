package linked_list.problem19;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        int len = 0;
        dummy.next = head;
        ListNode first = head;
        while (first != null) {
            len++;
            first = first.next;
        }
        len = len - n;
        first = dummy;
        while (len > 0) {
            len--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

public class removeNthNodeFromEndOfList {
    
}
