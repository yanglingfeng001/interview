package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class replaceSpace {
    //主要考察java中对stringbuffer类的应用
    public String replaceSpace(StringBuffer str) {
        for(int i=0;i<str.length();++i)
        {
            if(String.valueOf(str.charAt(i)).equals(" "))//找到空格了，只需要替换即可
            {
                str.deleteCharAt(i);
                str.insert(i,"%20");
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str=new StringBuffer("We Are Happy");
        String s=new replaceSpace().replaceSpace(str);
        System.out.println(s);
    }
}
