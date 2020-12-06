package linked_list;

public class sortLinkedListv2 {
    public static void main(String[] args) {
        ListNode a = new ListNode(44);
        ListNode b = new ListNode(11);
        ListNode c = new ListNode(23);
        ListNode d = new ListNode(34);
        ListNode e = new ListNode(64);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode t = sortList(a);
        while (t!=null){
            System.out.println(t.val);
            t=t.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        if (head==null) return head;
        return mergeSort(head, null);
    }
    public static ListNode mergeSort(ListNode left, ListNode right){
        if (left==null) return left;
        if (left.next == right){
            left.next = null;
            return left;
        }

        ListNode slow = left;
        ListNode fast = left;
        while (fast.next!=right){
            slow = slow.next;
            fast = fast.next;
            if (fast.next!=right){
                fast = fast.next;
            }
        }

        ListNode list1 = mergeSort(left, slow);
        ListNode list2 = mergeSort(slow, right);
        return merge(list1, list2);
    }
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        ListNode l1head = list1;
        ListNode l2head = list2;
        while (l1head!=null&&l2head!=null){
            if (l1head.val<l2head.val){
                dummyHead.next = l1head;
                dummyHead = dummyHead.next;
                l1head = l1head.next;
            }
            else {
                dummyHead.next = l2head;
                dummyHead = dummyHead.next;
                l2head = l2head.next;
            }
        }
        while (l1head!=null){
            dummyHead.next = l1head;
            dummyHead = dummyHead.next;
            l1head = l1head.next;
        }
        while (l2head!=null){
            dummyHead.next = l2head;
            dummyHead = dummyHead.next;
            l2head = l2head.next;
        }
        return dummy.next;
    }
}
