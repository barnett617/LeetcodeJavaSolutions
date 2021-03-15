# 打卡Week2

## 题目

- [add-two-numbers](https://leetcode-cn.com/problems/add-two-numbers/)
- [reverse-linked-list](https://leetcode-cn.com/problems/reverse-linked-list/)

## 解答

```js
function addTwoNumbers(n1, n2) {
  const dummy = new Node(0);
  const p = n1;
  const q = n2;
  const curr = dummy;
  let carry = 0;
  while (p) {
    let x = p ? p.val : 0;
    let y = q ? q.val : 0;
    let sum = x + y + carry;
    carry = sum / 10;
    curr.next = new Node(sum % 10);
    curr = curr.next;
    if (p) p = p.next;
    if (q) q = q.next;
  }
  if (carry) {
    curr.next = new Node(carry);
  }
  return dummy.next;
}
```

```js
function reverseLinkedList(head) {
  return reverseHelper(head, newHead);
}
function reverseHelper(head, newHead) {
  if (!head) return newHead;
  const TempNext = head.next;
  head.next = newHead;
  newHead = head;
  head = TempNext;
  return reverseHelper(head, newHead);
}
```

## 总结

- 哨兵节点
- 递归