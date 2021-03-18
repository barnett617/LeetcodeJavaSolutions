package binary_tree.problem250;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// 官方解法1
class Solution1 {
    int count = 0;
    private boolean is_uni(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean flag = true;
        if (node.left != null) {
            flag = is_uni(node.left) && flag && node.left.val == node.val;
        }
        if (node.right != null) {
            flag = is_uni(node.right) && flag && node.right.val == node.val;
        }
        if (!flag) {
            return false;
        }
        count++;
        return true;
    }
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        is_uni(root);
        return count;
    }
}

class Solution2 {
    int count = 0;
    private boolean is_valid_part(TreeNode node, int val) {
        if (node.left == null && node.right == null) return true;
        boolean left = is_valid_part(node.left, node.val);
        boolean right = is_valid_part(node.right, node.val);
        if (!left || !right) {
            return false;
        } 
        count++;
        return node.val == val;
    }
    public int CountUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
}

public class CountUnivalueSubtree {
    
}
