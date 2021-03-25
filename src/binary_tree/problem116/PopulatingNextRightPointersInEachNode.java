package binary_tree.problem116;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node(int x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> Q = new LinkedList<Node>();
        while (Q.size() > 0) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Node node = Q.poll();
                if (i < size - 1) {
                    node.next = Q.peek();
                }
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) return root;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}

public class PopulatingNextRightPointersInEachNode {
    
}
