package linked_list.problem138;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;
    Node(int x) {
        val = x;
        next = null;
        random = null;
    }
}

public class CopyListWithRandomPointer {
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (this.visited.containsKey(head)) return this.visited.get(head);
        Node newNode = new Node(head.val);
        this.visited.put(head, newNode);
        newNode.next = copyRandomList(newNode.next);
        newNode.random = copyRandomList(newNode.random);
        return newNode;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return head;

        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = ptr.next.next;
        }
        
        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next; 
        }

        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_new = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_new;
    }
}
