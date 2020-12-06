package linked_list;

import java.util.LinkedList;
import java.util.List;

public class sortLinkedList {
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
            t = t.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        if (head==null) return head;
        ListNode thead = new ListNode(-1);
        ListNode tpoint = thead;
        List<Integer> list = new LinkedList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        List<Integer> tmp = new LinkedList<>();
        for (Integer in:list){
            tmp.add(0);
        }
        mergeSort(list,0,list.size()-1,tmp);
        for (Integer in:list){
            ListNode t = new ListNode(in);
            tpoint.next = t;
            tpoint = t;
//            System.out.println(in);
        }
        return thead.next;
    }
    public static void mergeSort(List<Integer> list, int low, int high, List<Integer> tmp){
        if (low>=high)return;
        int mid = (low+high)/2;
        mergeSort(list,low,mid,tmp);
        mergeSort(list,mid+1,high,tmp);
        merge(list, low, mid, high, tmp);
    }
    public static void merge(List<Integer> list, int low, int mid, int high, List<Integer> tmp){
        int i=low,l=low,r=mid+1;
        while (l<=mid&&r<=high){
            if (list.get(l)<list.get(r)){
                tmp.set(i++,list.get(l++));
            }
            else {
                tmp.set(i++,list.get(r++));
            }
        }
        while (l<=mid){
            tmp.set(i++,list.get(l++));
        }
        while (r<=high){
            tmp.set(i++,list.get(r++));
        }
        for(int j=low;j<=high;j++){
            list.set(j, tmp.get(j));
        }
    }
}
