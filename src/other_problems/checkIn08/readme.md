# 打卡Week8

## 题目

- [LRU缓存](https://leetcode.com/problems/lru-cache/)
- [二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

## 解答

```js
var LRUCache = function(capacity) {
    this.list = [];
    this.capacity = capacity;
}

LRUCache.prototype.get = function(key) {
    for (let i = 0; i < this.list.length; i++) {
        const item = this.list[i];
        if (item.key === key) {
            const value = item.value;
            this.list.splice(i, 1);
            this.list.push(item);
            return value;
        }
    }
    return -1;
}

LRUCache.prototype.put = function(key, value) {
    for (let i = 0; i < this.list.length; i++) {
        const item = this.list[i];
        if (item.key === key) {
            item.value = value;
            this.list.splice(i, 1);
            this.list.push(item);
            return;
        }
    }
    this.list.push({ key, value });
    if (this.list.length > this.capacity) {
        this.list.shift();
    }
}
```

```js
var lowestCommonAncestor = function(root, p, q) {
    if (!root || root === p || root === q) return root;
    const left = lowestCommonAncestor(root.left, p, q);
    const right = lowestCommonAncestor(root.right, p, q);
    if (!left) return right;
    if (!right) return left;
    return root;
}
```

## 总结

- 优先级队列/有序字典
- 树递归