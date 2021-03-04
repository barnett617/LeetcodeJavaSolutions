package linked_list.problem206;

import linked_list.single.MyLinkedList;

import java.util.ArrayList;
import java.util.List;

import linked_list.single.ListNode;

class Solution {

    public ListNode reverseLinkedList1(ListNode head) {
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

    public ListNode reverseLinkedLis2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return p;  
    }

    public ListNode reverseLinkedList(ListNode head) {
        return reverse(head, null);
    }
    
    // @see assets/imgs/reverseLinkedList.png
    public ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        return reverse(head, newHead);
    }
 }

public class reverseLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtIndex(1, 2);
        list.addAtIndex(2, 3);
        List<Integer> listValue = new ArrayList<Integer>();
        ListNode originHead = MyLinkedList.head;
        while (MyLinkedList.head != null) {
            listValue.add(MyLinkedList.head.val);
            MyLinkedList.head = MyLinkedList.head.next;
        }
        MyLinkedList.head = originHead;
        System.out.println(listValue.toString());
        Solution s = new Solution();
        ListNode newList = s.reverseLinkedList(MyLinkedList.head);
        List<Integer> result = new ArrayList<Integer>();
        while (newList != null) {
            result.add(newList.val);
            newList = newList.next;
        }
        System.out.println(result.toString());
    }
}
