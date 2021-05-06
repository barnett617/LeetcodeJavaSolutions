function ListNode(val) {
    this.val = val;
    this.next = null;
}

var listOfDepth = function(tree) {
    const ans = [], temp = [];
    var helper = function(root, level) {
        if (!root) return;
        const node = new ListNode(root.val);
        if (!ans[level]) {
            ans[level] = node;
            temp[level] = node;
        } else {
            temp[level].next = node;
            temp[level] = node;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
    helper(tree, 0);
    return ans;
}