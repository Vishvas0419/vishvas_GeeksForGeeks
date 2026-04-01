class Solution {
    static int[][]dp = new int[101][101];
    static int matrixMultiplication(int arr[]) {
        for(int i=0;i<101;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(arr,1,arr.length-1);
    }
    private static int solve(int[]arr,int i,int j)
    {
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int tempAns = solve(arr,i,k) + 
                            solve(arr,k+1,j) +
                            arr[i-1]*arr[k]*arr[j];
            if(tempAns < min)
            {
                min = tempAns;
            }
        }
        return dp[i][j] = min;
    }
}