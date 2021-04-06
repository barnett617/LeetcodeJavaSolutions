function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val);
    this.next = (next === undefined ? null : next);
}
var sortList = function(head) {
    var merge = function (n1, n2) {
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
        if (p !== null) p.next = null;
        let n1 = helper(slow);
        let n2 = helper(head);
        return merge(n1, n2);
    }
    return head === null ? null : helper(head);
}