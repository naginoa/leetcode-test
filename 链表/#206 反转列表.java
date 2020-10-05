class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        Deque<ListNode> deque = new LinkedList();
        while (head.next!=null){
            deque.addFirst(head);
            head = head.next;
        }
        deque.addFirst(head);
        ListNode dummy = new ListNode(-1);
        head = dummy;
        for (ListNode it:deque){
            head.next = it;
            head = head.next;
        }
        head.next = null;
        return dummy.next;
    }
}