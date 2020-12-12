public static ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null) return null;
        HashSet<ListNode> set = new HashSet<>();
        while (head.next!=null){
            if (!set.add(head))return head;
//            System.out.println(set.add(head));
            head = head.next;
        }
        return null;
    }
}