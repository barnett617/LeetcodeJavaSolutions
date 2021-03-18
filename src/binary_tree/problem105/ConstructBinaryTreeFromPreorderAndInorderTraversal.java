package binary_tree.problem105;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int pre_idx;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre_idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, pre_idx, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        Integer root_val = preorder[pre_idx];
        pre_idx++;
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);
        root.left = helper(preorder, inorder, in_left, index - 1);
        root.right = helper(preorder, inorder, index + 1, in_right);
        return root;
    }
}

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
}
