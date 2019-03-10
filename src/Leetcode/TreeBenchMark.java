package Leetcode;

public class TreeBenchMark {
    public TreeNode create()
    {
        TreeNode t1=new TreeNode(0);
        t1.left=new TreeNode(1);
        t1.right=new TreeNode(2);
        t1.left.left=new TreeNode(3);
        t1.left.right=new TreeNode(4);
        t1.right.right=new TreeNode(6);
        return t1;
    }
}
