function TreeNode(val, left, right) {
    this.val = (val === undefined) ? 0 : val;
    this.left = (left == undefined) ? null : left;
    this.right = (right == undefined) ? null : right;
}

var pathSum = function(root, target) {
    const ans = [], cur = [];
    var helper = function (root, target) {
        if (!root) return;
        cur.push(root.val);
        if (root.val === target && !root.left && !root.right) {
            ans.push(cur.slice());
        }
        helper(root.left, target - root.val);
        helper(root.right, target - root.val);
        cur.pop();
    }
    helper(root, target);
    return ans;
}