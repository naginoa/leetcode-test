class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        Deque<ListNode> deque = new LinkedList<>();
        while (head!=null){
            deque.addFirst(head);
            head = head.next;
        }
        while (deque.size()>1){
            if (deque.removeLast().val!=deque.removeFirst().val){
                return false;
            }
        }
        return true;
    }
}