package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
//      public boolean preorder(TreeNode root,HashSet<Integer> s,int k)
//      {
//          if(root!=null)
//          {
//              if(s.contains(k-root.val))
//                  return true;
//              else
//              {
//                  s.add(root.val);
//                  return preorder(root.left,s,k)||preorder(root.right,s,k);
//              }
//          }
//          return false;
//      }
//      public boolean findTarget(TreeNode root, int k) {
//          HashSet<Integer> s=new HashSet<>();
//          return preorder(root,s,k);
//      }
    public void PreOdermergeTree(TreeNode t1,TreeNode t2)
    {
        //先序遍历然后相加即可
        if(t1!=null||t2!=null)//两边都没有即为停止条件
        {

        }

    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        PreOdermergeTree(t1,t2);
        return t1;
    }
  }