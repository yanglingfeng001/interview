package Leetcode;

import java.util.Stack;

public class Tree_ThreeOrder {
    public void PreOrder(TreeNode root)//给定根结点写出非递归版先序遍历
    {
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=root;
        while(p!=null||!s.empty())
        {
            while(p!=null) {
                visit(p);
                s.push(p);
                p=p.left;//直到左边这条路已经完全走不下去了
            }
            if(!s.empty())
            {
                p=s.pop();
                p=p.right;//拉到右边这条路来
            }
        }
    }
    public void Inorder(TreeNode root)//给定根结点写出中序遍历非递归版
    {
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=root;
        while(p!=null||!s.empty())
        {
            while(p!=null)
            {
                s.push(p);
                p=p.left;
            }
            if(!s.empty())
            {
                p=s.pop();
                visit(p);
                p=p.right;
            }
        }
    }
    public void PostOrder(TreeNode root)//左右根
    {
        Stack<TreeNode_tag> s=new Stack<>();
        TreeNode p=root;
        TreeNode_tag temp;
        while(p!=null||!s.empty())//最终终止条件，遍历结束条件
        {
            while(p!=null)//证明右边的子树遍历已经完成
            {
                s.push(new TreeNode_tag(p,true));
                p=p.left;//左右根中的左
            }
            if(!s.empty())
            {
                temp=s.pop();
                if(temp.tag)
                {
                    temp.tag=false;//如果是第一次走到左边的根，表明此时已经不是第一次，并再次入栈
                    s.push(temp);
                    p=temp.node.right;//左右根中的右
                }
                else{
                    visit(temp.node);
                    p=null;
                }
            }
        }
    }
    public void visit(TreeNode node)
    {
        System.out.println(node.val);
    }
    public int GetWpl(TreeNode node,int n)//求带权路径长度(包含非叶子结点的版本)
    {
        if(node==null) return 0;
        else return n*node.val+GetWpl(node.left,n+1)+GetWpl(node.right,n+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeBenchMark().create();
        new Tree_ThreeOrder().PostOrder(root);
    }
}
