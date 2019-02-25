package MyCollection;

public class ListNode {
    public Object data;
    public ListNode next;
    public ListNode()//构造函数
    {
        this.data=null;
        this.next=null;
    }
    public ListNode(Object data)
    {
        this.data=data;
        this.next=null;
    }
    public ListNode(Object data,ListNode next)
    {
        this.data=data;
        this.next=next;
    }
    public String toString()
    {
        return "ListNode("+data.toString()+")";
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l0=new ListNode(0,l1);
        System.out.println(l0);
    }
}
