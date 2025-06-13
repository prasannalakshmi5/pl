public class Fibonacci{
    public static int FibTab(int n){
        if(n<=1){
            return n;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=10;
        System.out.println("Fibonacci of"+n+"is"+FibTab(n));
    }
}