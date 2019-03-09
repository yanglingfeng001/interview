package Leetcode;

public class JumpSpace {
    public int JumpFloor(int target) {
        if(target<=0) return 0;
        else if(target==1) return 1;
        else if(target==2) return 2;
        else return JumpFloor(target-1)+JumpFloor(target-2);
    }
    public int JumpFloorII(int target) {
        int a=0;
        for(int i=1;i<=target;++i)
        {
            a+=JumpFloor(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int a=new JumpSpace().JumpFloorII(1);
        System.out.println(a);
    }
}
