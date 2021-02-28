package linked_list.single.test;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

class MyLinkedList2 {
    int size;
    ListNode head;
    public MyLinkedList2() {
        size = 0;
        head = new ListNode(0);
    }
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        for (int i = 0; i <= index; i++) curr = curr.next;
        return curr.val;
    }
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        ListNode curr = head;
        size++;
        ListNode toAdd = new ListNode(val);
        for (int i = 0; i < index; i++) curr = curr.next;
        toAdd.next = curr.next;
        curr.next = toAdd; 
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        curr.next = curr.next.next;
    }
}
class Main2 {
    public static void main(String[] args) {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(3);
        list.addAtTail(5);
        int param1 = list.get(1);
        list.addAtIndex(1, 4);
        int param2 = list.get(1);
        list.deleteAtIndex(1);
        int param3 = list.get(1);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
    }
}
