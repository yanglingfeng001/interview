package Leetcode;

import java.util.ArrayList;
import java.util.List;



public class two_Jump {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public int JumpFloor(int target) {
        return (int)Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        System.out.println(list.get(0));
    }
}
