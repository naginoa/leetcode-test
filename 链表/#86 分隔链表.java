class Solution {
    public static ListNode partition(ListNode head, int x) {
        if (head == null)return head;
        ListNode a1 = new ListNode(-1);
        ListNode b1 = new ListNode(-1);
        ListNode ahead = a1;
        ListNode bhead = b1;

        while (head!=null){
            if (head.val < x){
                a1.next = head;
                a1 = a1.next;
//                System.out.println("a");
            }
            else {
                b1.next = head;
                b1 = b1.next;
//                System.out.println("b");
            }
            head = head.next;
        }
        a1.next = null;
        b1.next = null;

        a1.next = bhead.next;
        return ahead.next;
    }
}