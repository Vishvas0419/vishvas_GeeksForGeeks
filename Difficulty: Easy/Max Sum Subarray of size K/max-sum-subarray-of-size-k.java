class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int i=0,j=0,sum = 0,maxSum= Integer.MIN_VALUE;
        while(j<arr.length)
        {
            sum += arr[j];
            if(j-i+1 == k)
            {
                maxSum = Math.max(maxSum,sum);
                sum -= arr[i];
                i++;j++;
            }
            else{
                j++;
            }
        }
        return maxSum;
        
    }
}