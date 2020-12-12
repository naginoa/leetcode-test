public class Solution {
    public static ListNode detectCycle(ListNode head){
        if (head==nullhead.next==nullhead.next.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode tmp = head;
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)fast = fast.next;
            if (slow==fast){
                while (tmp!=slow){
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}