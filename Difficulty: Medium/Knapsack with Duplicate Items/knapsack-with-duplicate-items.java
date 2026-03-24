class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int n = wt.length;
        int[][]dp = new int[n+1][capacity+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=capacity;j++)
            {
                if(i==0||j==0) dp[i][j] = 0;
                else if(wt[i-1]<=j)
                {
                    int pick = val[i-1] + dp[i][j-wt[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = Math.max(pick,notPick);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][capacity];
        
    }
}