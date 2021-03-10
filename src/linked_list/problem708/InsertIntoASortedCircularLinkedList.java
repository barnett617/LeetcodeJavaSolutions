package linked_list.problem708;

class Node {
    int val;
    Node next;
    Node (int x, Node next) {
        val = x;
        this.next = next;
    }
}

class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }
        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;
        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                toInsert = true;
            } else if (prev.val > curr.val) {
                if (insertVal > prev.val || insertVal < curr.val) {
                    toInsert = true;
                }
            }
            if (toInsert) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        prev.next = new Node(insertVal, curr);
        return head;
    }
}

public class InsertIntoASortedCircularLinkedList {
    
}
