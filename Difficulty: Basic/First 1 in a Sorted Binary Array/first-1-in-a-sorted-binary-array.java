// User function Template for Java

class Solution {

    public long firstIndex(int arr[]) {
        int left = 0,right=arr.length-1,ans = -1;
        while(left<=right)
        {
            int mid = left+right-left/2;
            if(arr[mid]==1)
            {
                ans  = mid;
                right = mid-1; //move left
            }
            else{
                left = mid+1; //move right
            }
        }
        return ans;
    }
}