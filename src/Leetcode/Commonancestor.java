package Leetcode;

import java.util.ArrayList;
import java.util.List;
//求两个结点的公共祖先
public class Commonancestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return null;
    }
    public void GetNodePath(TreeNode root,TreeNode target, ArrayList<TreeNode> list,boolean flag)//找到root到target的路径并存到list中
    {
        if (root == null || flag == true)//根为空或者node已经找到了
            return;
        GetNodePath(root.left, target, list, flag);
        GetNodePath(root.right, target, list, flag);
        if (root.val == target.val || flag == true)//找到node或者root为node到根节点路径上的节点
        {
            list.add(root);//存储从node到根节点的路径
            flag = true;
        }
    }

    public static void main(String[] args) {

    }
}
