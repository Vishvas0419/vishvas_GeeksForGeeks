class Solution {

    static int findFloor(int[] arr, int x) {
        // floor  = largest value smaller than equal to x
        int n  = arr.length;
        int ans = -1;
        int low = 0 , high = n-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]<=x)
            {
                ans = mid;
                low = mid+1; //find more largest value on right side 
            }
            else high = mid-1; //if arr[mid] value is greater than x check on left side
        }
        return ans;
    }
}
