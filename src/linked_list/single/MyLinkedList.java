package linked_list.single;

public class MyLinkedList {
    int size;
    public static ListNode head;
    public MyLinkedList() {
        size = 0;
        // sentinel node
        head = new ListNode(0); 
    }
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        for (int i = 0; i < index + 1; i++) curr = curr.next;
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
        size++;
        ListNode pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) pred = pred.next;
        pred.next = pred.next.next;
    }
}
class Main {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(3);
        obj.addAtTail(5);
        // 3 -> 5
        int params1 = obj.get(1);
        // 5
        obj.addAtIndex(1, 4);
        // 3 -> 4 -> 5
        int params2 = obj.get(1);
        // 4
        obj.deleteAtIndex(1);
        // 3 -> 5
        int params3 = obj.get(1);
        // 5
        System.out.println(params1);
        System.out.println(params2);
        System.out.println(params3);
    }
}