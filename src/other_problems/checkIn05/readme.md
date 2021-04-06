# 打卡Week5

## 题目

- [汉诺塔问题](https://leetcode-cn.com/problems/hanota-lcci/)
- [排序链表](https://leetcode-cn.com/problems/sort-list/)

## 解答

```js
var hanota = function(A, B, C) {
    var helper = function(n, A, B, C) {
        if (n === 1) {
            C.push(A.pop());
        }
        if (n > 1) {
            helper(n - 1, A, C, B);
            C.push(A.pop());
            helper(n - 1, B, A, C);
        }
    }
    helper(A.length, A, B, C);
}
```

```js
function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
}
var sortList = function(head) {
    var merge = function(n1, n2) {
        let dummy = new ListNode(0);
        let cur = dummy;
        while (n1 !== null && n2 !== null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                cur = cur.next;
                n1 = n1.next;
            } else {
                cur.next = n2;
                cur = cur.next;
                n2 = n2.next;
            }
        }
        if (n1 !== null) {
            cur.next = n1;
        }
        if (n2 !== null) {
            cur.next = n2;
        }
        return dummy.next;
    }
    var helper = function(head) {
        if (head.next === null) {
            return head;
        }
        let fast = head;
        let slow = head;
        let p = null;
        while (fast !== null && fast.next !== null) {
            p = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        p.next = null;
        let n1 = helper(head);
        let n2 = helper(slow);
        return merge(n1, n2);
    }
    return head === null ? null : helper(head);
}
```

## 总结

- 递归
- 分治