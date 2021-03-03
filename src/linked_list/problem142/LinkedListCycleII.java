package linked_list.problem142;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode helper(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode intersect = helper(head);
        if (intersect == null) return null;
        ListNode p1 = head;
        ListNode p2 = intersect;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        } 
        return p1;
    }
}

public class LinkedListCycleII {
    public static void main(String[] args) {
        
    }
}
