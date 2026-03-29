// User function Template for Java

class Solution {
    public int minOperations(String s1, String s2) {
        int insertions = s1.length()-lcs(s1,s2);
        int deletions = s2.length()-lcs(s1,s2);
        return insertions+deletions;
    }
    private static int lcs(String text1, String text2) {
        int m = text1.length(); int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}