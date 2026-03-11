class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        int [][]dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return helper(W,val,wt,n,dp);
    }
    public int helper(int W,int []val,int []wt,int n,int[][]dp)
    {
        if(n==0 || W==0) return 0;
        if(dp[n][W]!=-1) return dp[n][W];
        if(wt[n-1]<=W)
        {
            int pick = val[n-1] + helper(W-wt[n-1],val,wt,n-1,dp);
            int notPick = helper(W,val,wt,n-1,dp);
            return dp[n][W] = Math.max(pick,notPick);
        }
        else
        {
            dp[n][W] = helper(W,val,wt,n-1,dp);
        }
        return dp[n][W];
    }
}
