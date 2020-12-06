package linked_list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Reorder {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        reorderList(a);
        System.out.println(a);
    }
    public static void reorderList(ListNode head) {
        if (head==null)return;
        ListNode h = head;
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        Deque<ListNode> deque1 = new LinkedList<>();
        Deque<ListNode> deque2 = new LinkedList<>();

        int jiaobiao = 0;
        while (h!=null){
            if (jiaobiao%2==0){
                deque1.addFirst(h);
//                dummyHead1.next = head;
//                dummyHead1 = dummyHead1.next;
            }
            else {
                deque2.addLast(h);
//                dummyHead2.next = head;
//                dummyHead2 = dummyHead2.next;
            }
            h = h.next;
            jiaobiao++;
        }
        h = head;
        while (jiaobiao>0){
            if(jiaobiao % 2==0){
                h.next = deque1.removeLast();
//                int aa = deque1.getLast().val;
//                deque1.removeLast();
//                h = deque1.removeLast();
            }
            else {
//                int aa = deque2.getLast().val;
//                h.next = deque2.getLast();
//                deque2.removeLast();
                h.next = deque2.removeLast();
            }
            h = h.next;
            jiaobiao--;
        }
    }
}
