class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[]length = new int[n+1];
        for(int i=1;i<=n;i++) length[i] = i;
        int[][]dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0||j==0) dp[i][j]=0;
                else if(i<=j)
                {
                    int pick = price[i-1] + dp[i][j-i];
                    int notPick = dp[i-1][j];
                    dp[i][j] = Math.max(pick,notPick);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}