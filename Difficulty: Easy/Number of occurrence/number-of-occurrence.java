//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        int lb = lowerBound(arr,n,target);
        int ub = upperBound(arr,n,target);
        if(lb == n || arr[lb] != target) return 0;
        return ub-lb;
    }
    public int upperBound(int[] arr,int n,int target)
    {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]>target)
            {
                ans = mid;
                high = mid-1; //look for index in left side
            }
            else{
                low = mid + 1; //look for the right side
            }
        }
        return ans;
    }
    public int lowerBound(int[] arr,int n,int target)
    {
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid]>=target)
            {
                ans = mid;
                high = mid-1; //look for index in left side
            }
            else{
                low = mid + 1;//else look for right side 
            }
        }
        return ans;
    }
}

