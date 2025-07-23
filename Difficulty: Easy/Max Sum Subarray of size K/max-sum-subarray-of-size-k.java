// User function Template for Java

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        int i=0,j=0,n=arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while(j<n)
        {
            sum = sum+arr[j];
            if(j-i+1 < k) j++;
            else if(j-i+1 == k)
            {
                maxSum = Math.max(maxSum,sum);
                sum = sum-arr[i];
                i++;j++;
            }
        }
        return maxSum;
    }
}