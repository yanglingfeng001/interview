package Leetcode;

import java.util.ArrayList;
import java.util.List;
public class modify_array {
    public void swap(int a[],int i,int j)
    {
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
    public void reOrderArray(int [] array) {//不改变顺序
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        for(int i:array)
        {
            if(i%2==0)//偶数
                even.add(i);
            else
                odd.add(i);
        }
        for(int i=0;i<odd.size();++i)
        {
            array[i]=odd.get(i);
        }
        for(int i=0;i<even.size();++i)
        {
            array[i+odd.size()]=even.get(i);
        }
    }

    public static void main(String[] args) {
        int a[]={7,2,4,5,1,3};
        new modify_array().reOrderArray(a);
        for(int i:a)
        {
            System.out.println(i);
        }
    }
}
