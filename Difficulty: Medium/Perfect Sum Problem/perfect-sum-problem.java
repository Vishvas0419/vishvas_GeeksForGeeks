class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        // Base case: for sum 0(j=0) an only empty subset makes count=1 
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {  // ← start j from 0, not 1
                if (nums[i - 1] <= j) {
                    // Pick current element + don't pick
                    int pick = dp[i-1][j-nums[i-1]];
                    int notPick = dp[i-1][j];
                    dp[i][j] = (pick+notPick) % 1000000007;
                } else {
                    // Can't pick current element
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}