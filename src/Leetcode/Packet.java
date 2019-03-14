package Leetcode;

public class Packet {
    //0-1背包可优化空间复杂度
    public static int DP_01bag(int m,int n,int w[],int p[]){//m背包重量，n物品数量，w物品重量，p物品价值
        //c[i][m] 表示前i件物品恰好放入重量为m的背包时的最大价值
        int c[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            c[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            c[0][j] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //当物品第i件此时背包重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if(w[i-1] <= j){//假设当前背包重量可以容纳第i件物品
                    if(c[i-1][j] <c[i-1][j-w[i-1]]+p[i-1]){
                        c[i][j] = c[i-1][j-w[i-1]]+p[i-1];
                    }else{//总价值还不如上个物品在此种重量下的背包带来的收益，取上即可
                        c[i][j] = c[i-1][j];
                    }
                }else{//当前背包重量不能容纳第i件物品，就是不选第i件物品，总价值最大是当前背包重量下第i-1个物品的总价值
                    c[i][j] = c[i-1][j];
                }
            }
        }
        return c[n][m];
    }
    public static int NDP_01bag(int m,int n,int w[],int p[]){//优化空间复杂度版本0-1背包
        int dp[] = new int[m+1];
        for(int i=0;i<m+1;++i)
        {
            dp[i]=0;
        }
        for(int i=0;i<n;++i)//遍历物品
        {
            for(int j=m;j>0;--j)
            {
                if(w[i]<=j&&(dp[j]<dp[j-w[i]]+p[i]))//格子够装,且要装才有可能改变值
                {
                    dp[j]=dp[j-w[i]]+p[i];
                }
            }
        }
        return dp[m];
    }
    public static int ENDP_01bag(int m,int n,int w[],int p[]){//优化空间复杂度版本0-1背包完全版,物品可以任意拿多次
        int dp[] = new int[m+1];
        for(int i=0;i<m+1;++i)
        {
            dp[i]=0;
        }
        for(int i=0;i<n;++i)//遍历物品
        {
            for(int j=1;j<m+1;++j)
            {
                if(w[i]<=j&&(dp[j]<dp[j-w[i]]+p[i]))//格子够装,且要装才有可能改变值
                {
                    dp[j]=dp[j-w[i]]+p[i];
                }
            }
        }
        return dp[m];
    }
    public static void main(String[] args) {
        int w[]={4,3,1};
        int p[]={3000,2000,1500};
        int a=Packet.ENDP_01bag(4,3,w,p);
        System.out.println(a);
    }

}
