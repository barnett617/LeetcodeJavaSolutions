package binary_tree.problem117;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    public Node (int x) {
        this.val = x;
    }
}

// the difference of problem116 is problem116 is basic on a perfect binary tree
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);
        while (Q.size() > 0) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Node curr = Q.poll();
                if (i < size - 1) {
                    curr.next = Q.peek();
                }
                if (curr.left != null) {
                    Q.add(curr.left);
                }
                if (curr.right != null) {
                    Q.add(curr.right);
                }
            }
        }
        return root;
    }

    Node leftmost, prev;

    public void processChild(Node node) {
        if (node != null) {
            if (this.prev != null) {
                // has node on the left
                this.prev.next = node;
            } else {
                // leftest node
                this.leftmost = node;
            }
            // anyway set the curr node as prev
            this.prev = node;
        }
    }

    public Node connect2(Node root) {
        if (root == null) return root;
        // root beginning
        this.leftmost = root;
        Node curr = leftmost;
        // while loop
        while (this.leftmost != null) {
            // the prev of leftmost must be null
            this.prev = null;
            // begin from leftmost
            curr = this.leftmost;
            // !!! go on the loop only if there has leftmost node
            this.leftmost = null;
            while (curr != null) {
                this.processChild(curr.left);
                this.processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }
}
