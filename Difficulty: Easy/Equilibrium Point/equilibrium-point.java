class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        int [] prefixSum = new int[n]; 
        prefixSum[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        for(int i=0;i<n;i++)
        {
            int leftSum = prefixSum[i] - arr[i];
            int rightSum = prefixSum[n-1] - prefixSum[i];
            if(leftSum == rightSum) return i;
        }
        return -1;
        
    }
}
