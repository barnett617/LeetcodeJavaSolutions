# 打卡Week10

## 题目

- [路径总和Ⅲ](https://leetcode-cn.com/problems/path-sum-iii/submissions/)
- [根据前序和后序遍历构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)\\

## 解答

```js
var pathSum = function(root, targetSum) {
    let helper = function(root, target, map, curSum) {
        if (!root) return 0;
        curSum += root.val;

        let ans = 0;
        ans += map.get(curSum - target) || 0;
        const curSumVal = map.get(curSum);
        const newVal = curSumVal ? curSumVal + 1 : 1;
        map.set(curSum, newVal);

        ans += helper(root.left, target, map, curSum);
        ans += helper(root.right, target, map, curSum);

        const oldVal = map.get(curSum) - 1;
        map.set(curSum, oldVal);

        return ans;
    }

    const map = new Map();
    map.set(0, 1);
    return helper(root, targetSum, map, 0);
}
```

```js
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

var constructFromPrePost = function(pre, post) {
    if (!pre || !pre.length) return null;
    const root = new TreeNode(pre[0]);
    if (pre.length === 1) return root;

    const idx = post.indexOf(pre[1]);
    const flag = pre[idx + 1] ? (idx + 2) : undefined;

    root.left = constructFromPrePost(pre.slice(1, flag), post.slice(0, idx + 1));
    root.right = constructFromPrePost(pre.slice(idx + 2), post.slice(idx + 1, -1));

    return root;
}
```

## 总结

- 前缀和递归+回溯
- 递归