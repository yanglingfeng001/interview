package Leetcode;

public class LinkNode {
    int val;
    LinkNode next;
    LinkNode(int val)
    {
        this.val=val;
        this.next=null;
    }
    static boolean IsCirle(LinkNode node)//单链表是否有环
    {
        LinkNode slow=node,fast=node;
        while(fast!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast) return true;
        }
        return false;
    }
    static  int Circle_length(LinkNode node)//单链表环的长度
    {
        LinkNode slow=node,fast=node;
        while(fast!=null)
        {
            int flag=0;
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)//当碰撞第一次发生
            {
                fast=fast.next.next;
                slow=slow.next;
                flag++;
                while(fast!=slow)
                {
                    fast=fast.next.next;
                    slow=slow.next;
                    flag++;
                }
                return flag;
            }
        }
        return 0;
    }
}
