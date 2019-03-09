package Leetcode;

public class TwoDimensionArray {
    //最为常规的方式，一个个找不太好
//    public boolean Find(int target, int [][] array) {
//        boolean flag=false;
//        for(int i=0;i<array.length;++i)
//        {
//            for(int j=0;j<array[i].length;++j)
//            {
//                if(array[i][j]==target) flag=true;
//            }
//        }
//        return flag;
//    }
    public boolean Find(int target, int [][] array) {
        boolean flag=false;
        for(int i=0;i<array.length;++i)
        {
            //这样会减少一点循环的次数，稍微优化一点效率
            for(int j=0;j<array[i].length&&array[i][j]<=target;++j)
            {
                if(array[i][j]==target) flag=true;
            }
        }
        return flag;
    }
}
