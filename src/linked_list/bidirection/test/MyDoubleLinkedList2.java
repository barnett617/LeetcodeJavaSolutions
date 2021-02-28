package linked_list.bidirection.test;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) {
        val = x;
    }
}

class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        if (index + 1 < size - index) {
            for (int i = 0; i < index + 1; i++) curr = curr.next;
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
        ListNode succ = tail, pred = tail.prev;
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
            for (int i = 0; i < size - index; i++) succ = succ.prev;
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }
}

class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
        System.out.println(list.toString());
    }
}

// ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
// [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */