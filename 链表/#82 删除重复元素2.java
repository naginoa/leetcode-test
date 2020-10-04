class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while(head.next.next != null){
            if(head.next.val == head.next.next.val){
                ListNode temp = head;
                //当出现重复时,遍历到不重复的值的位置,将他直接给父节点.
                while(head.next.val==head.next.next.val){
                    head = head.next;
                    //处理1,1的情况 当head.next.next不足时直接两次跳出循环
                    if (head.next.next == null) break;
                }
                temp.next = head.next.next;
                if (head.next.next == null) break;
                head = temp;
            }
            else{
                head = head.next;
            }
            //System.out.println(head.val);
        }
        return dummy.next;
    }
}