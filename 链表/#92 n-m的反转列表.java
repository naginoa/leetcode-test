//1 ms, 在所有 Java 提交中击败了100.00%
//内存消耗：36.4 MB, 在所有 Java 提交中击败了85.39%的用户
//思路很简单就是借助栈来实现，一个栈放正常的，另一个栈放m-n之间的
//并且当m=1时有很多情况，第一个输出就不应该要了，并且最后一个输出的lenth还要注意
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null) return head;
        if(n==m)return head;
        Deque<ListNode> deque = new LinkedList();
        Deque<ListNode> deque1 = new LinkedList();
        int flag = 1;
        while (head!=null){
            if (flag>=m && flag<=n){
                deque1.addFirst(head);
            }
            else {
                deque.addLast(head);
            }
            head = head.next;
            flag += 1;
        }
        ListNode dummy = new ListNode(-1);
        head = dummy;
        int len = deque.size();
        int i = 1;
        if(m!=1){
            for (;i<m;i++){
                if(deque.size()>0){
                    ListNode tt = deque.removeFirst();
                    head.next = tt;
                    head = tt;
                }
//            System.out.println(deque.removeLast());
            }
        }
        for (;i<=n;i++){
            ListNode tt = deque1.removeFirst();
            head.next = tt;
            head = tt;
//            System.out.println(deque1.removeLast());
        }
        for (i = m-1;i<=len;i++){
            if(deque.size()>0){
                ListNode tt = deque.removeFirst();
                head.next = tt;
                head = tt;
            }
//            System.out.println(deque.removeLast());
        }
//        for (ListNode it:deque){
//            head.next = it;
//            head = head.next;
//        }
        head.next = null;

        return dummy.next;
    }
}