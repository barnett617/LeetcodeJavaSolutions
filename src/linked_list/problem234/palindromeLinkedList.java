package linked_list.problem234;

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (!list.get(start).equals(list.get(end))) return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfEnd = helper(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }

    private ListNode helper(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode reverseList2(ListNode head) {
        return helper2(head, null);
    }

    private ListNode helper2(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return helper2(head, newHead);
    }
}

public class palindromeLinkedList {
    
}
