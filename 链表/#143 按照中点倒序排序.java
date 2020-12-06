package linked_list;

import java.awt.desktop.AppReopenedListener;

public class Reorderv2 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        reorderList(a);
        System.out.println(a);
    }
    public static void reorderList(ListNode head) {
        //1.中点
        //2.中点前为正序子链表，中点后倒序子链表
        //3.两个链表连接
        if (head==null)return;
        //1
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next!=null){
                fast = fast.next;
            }
        }

        //2
        ListNode hleft = head;
        ListNode h = hleft;
        while (h!=slow){
            h = h.next;
        }
        ListNode hright = h.next;
        hright = reverse(hright);
        h.next = null;

        //3
        h = hleft;
        ListNode h2 = hright;
        ListNode n = new ListNode(-1);
        ListNode nh = n;
        int jiaobiao = 0;
        while (h!=null&&h2!=null){
            if (jiaobiao%2==0){
                nh.next = h;
                h = h.next;
            }
            else {
                nh.next = h2;
                h2 = h2.next;
            }
            nh = nh.next;
            jiaobiao ++;
        }
        while (h!=null){
            nh.next = h;
            h = h.next;
            nh = nh.next;
        }
        while (h2!=null){
            nh.next = h2;
            h2 = h2.next;
            nh = nh.next;
        }
        head = n.next;
        System.out.println();
    }
    public static ListNode reverse(ListNode head){
        if (head==null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur.next!=null){
            tmp = cur;
            cur = cur.next;
            tmp.next = pre;
            pre = tmp;
        }
        cur.next = pre;
        return cur;
    }
}
