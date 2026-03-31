class Solution {
    public int longestPalinSubseq(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        return lcs(s,sb.toString());
    }
    private static int lcs(String x,String y)
    {
        int m = x.length(); int n = y.length();
        int [][]dp = new int[m+1][n+1];
        for(int i = 1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(x.charAt(i-1)==y.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}