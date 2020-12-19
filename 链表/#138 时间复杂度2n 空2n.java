class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node t = head;
        Node thead = new Node(head.val);
        thead.random = head.random;
        Node pre = new Node(-1);
        pre = thead;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, thead);
        while(head.next!=null){
            head = head.next;
            Node tmp = new Node(head.val);
            // tmp.random = head.random;
            pre.next = tmp;
            pre = tmp;
            map.put(head, pre);
        }
        head = t;
        pre = thead;
        while(head!=null){
            pre.random = map.get(head.random);
            pre = pre.next;
            head = head.next;
        }
        return thead;
    }
}