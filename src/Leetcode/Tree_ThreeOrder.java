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
    public void PostOrder(TreeNode root)
    {
        Stack<TreeNode_tag> s=new Stack<>();
        TreeNode p=root;
        TreeNode_tag temp;
        while(p!=null||!s.empty())
        {
            while(p!=null)
            {
                s.push(new TreeNode_tag(p,true));
                p=p.left;
            }
            if(!s.empty())
            {
                temp=s.pop();
                if(temp.tag)
                {
                    temp.tag=false;
                    s.push(temp);
                    p=temp.node.right;
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

    public static void main(String[] args) {
        TreeNode root = new TreeBenchMark().create();
        new Tree_ThreeOrder().PostOrder(root);
    }
}
