function TreeNode = function(val) {
    this.val = val;
    this.left = this.right = null;
}

var constructFromPrePost = function(pre, post) {
    if (!pre || !pre.length) return null;
    const root = new TreeNode(pre[0]);
    if (pre.length === 1) return root;

    const idx = post.indexOf(pre[1]);
    const leftIdx = pre[idx + 1] ? idx + 2 : undefined;
    root.left = constructFromPrePost(pre.slice(1, leftIdx), post.slice(0, idx + 1));
    root.right = constructFromPrePost(pre.slice(idx + 2), post.slice(idx + 1, -1));

    return root;
}