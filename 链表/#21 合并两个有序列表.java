package linked_list;

public class MergeList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        d.next = e;
        e.next = f;
        c.next = g;

        ListNode t = mergeTwoLists(a, d);
        while (t!=null){
            System.out.println(t.val);
            t = t.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)return null;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1!=null&&l2!=null){
            if (l1.val < l2.val){
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
            else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        //不断测试就是少了任一为空时连接另一个
        if (l2==null){
            head.next = l1;
        };
        if (l1==null){
            head.next = l2;
        };
        return dummy.next;
    }
}
