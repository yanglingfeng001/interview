package Leetcode;

public class Fibo {
    public int Fibonacci(int n) {//斐波那契数列非递归形式
        int temp=0;
        if(n==0) return 0;
        else if(n==1||n==2) return 1;
        int prenum=1;
        int num=2;
        for(int i=3;i<n;++i)
        {
            temp=num;
            num+=prenum;
            prenum=temp;
        }
        return num;
    }
}
