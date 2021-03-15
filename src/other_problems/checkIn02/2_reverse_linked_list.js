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