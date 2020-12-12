public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (head.next!=null){
            if (fast.next==null)return false;
            slow = slow.next;
            fast = fast.next;
            if (fast.next!=null){
                fast = fast.next;
            }
            if (slow == fast)return true;
            head=head.next;
        }
        return false;
    }
}