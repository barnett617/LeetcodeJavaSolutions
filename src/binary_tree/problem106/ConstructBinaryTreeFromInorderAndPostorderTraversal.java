package binary_tree.problem106;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
    }
}

class Solution {
    int[] postorder;
    int[] inorder;
    int post_idx;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        post_idx = postorder.length - 1;
        int idx = 0;
        for (Integer val : inorder) {
            map.put(val, idx++);
        }
        return helper(0, postorder.length - 1);
    }
    private TreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        Integer root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);
        post_idx--;
        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index - 1);
        return root;
    }
}

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    
}
