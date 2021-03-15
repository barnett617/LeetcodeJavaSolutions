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