# 打卡Week9

## 题目

- [二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)
- [特定深度节点链表](https://leetcode-cn.com/problems/list-of-depth-lcci/)

## 解答

```js
var pathSum = function(root, target) {
    const ans = [], cur = [];
    var helper = function(root, target) {
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
```

```js
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
```

## 总结

- 回溯
- BFS