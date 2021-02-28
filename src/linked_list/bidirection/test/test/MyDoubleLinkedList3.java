package linked_list.bidirection.test.test;

class ListNode {
    int val;
    ListNode prev, next;
    ListNode(int x) { val = x; }
}
public class MyDoubleLinkedList3 {
    int size;
    ListNode head, tail;
    MyDoubleLinkedList3() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr;
        if (index + 1 < size - index) {
            curr = head;
            for (int i = 0; i < index + 1; i++)  curr = curr.next;
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) curr = curr.prev;
        }
        return curr.val;
    }
    public void addAtHead(int val) {
        ListNode pred = head, succ = head.next;
        size++;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }
    public void addAtTail(int val) {
        ListNode succ = tail, pred = succ.prev;
        size++;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) pred = pred.next;
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++) succ = succ.prev;
            pred = succ.prev;
        }
        size++;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) pred = pred.next;
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) succ = succ.prev;
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }
}