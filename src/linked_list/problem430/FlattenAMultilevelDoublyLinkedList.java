package linked_list.problem430;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    int val;
    Node prev;
    Node next;
    Node child;
    Node(int x, Node prev, Node next, Node child) {
        val = x;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node dummy = new Node(0, null, head, null);
        flattenDFS(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }
    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        Node tempNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        return flattenDFS(tail, tempNext);
    }
    public Node flatten2(Node head) {
        if (head == null) return head;
        Node dummy = new Node(0, null, head, null);
        Node curr, prev = dummy;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            curr.prev = prev;
            prev.next = curr;
            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}

public class FlattenAMultilevelDoublyLinkedList {
    
}
