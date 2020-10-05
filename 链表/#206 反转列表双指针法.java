class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null || head.next==null) return head;
        //双指针法,pre表示前一个指针,cur表示当前指针
        ListNode pre = null;
        ListNode cur = head;
        //t用来暂时存cur的next，因为会先把next变成pre
        ListNode t = null;
        while(cur!=null){
            t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
}