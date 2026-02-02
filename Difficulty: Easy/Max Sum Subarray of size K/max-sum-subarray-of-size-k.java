class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int i = 0;int j=0; int sum =0; int max = Integer.MIN_VALUE;
        while(j<arr.length)
        {
            sum += arr[j];
            if(j-i+1==k) {
                max = Math.max(max,sum);
                sum = sum-arr[i];
                i++;j++;
            }
            else{
                j++;
            }
        }
        return max;
    }
}