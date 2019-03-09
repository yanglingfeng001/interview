package Leetcode;

public class K_node {
    public ListNode FindKthToTail(ListNode head,int k) {
        try {
            ListNode p = head;
            for (int i = 0; i < k - 1; ++i) {
                head = head.next;
            }
            while (head.next != null) {
                head = head.next;
                p = p.next;
            }
            return p;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public static void main(String[] args) {
    }
}
