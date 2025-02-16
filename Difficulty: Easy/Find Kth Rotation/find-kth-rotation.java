//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int low = 0;
        int high = n-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(arr.get(low)<=arr.get(mid)) //if left half is sorted 
            {
                if(arr.get(low)<ans)
                {
                    index = low;
                    ans = arr.get(low);
                }
                low = mid+1;
                
            }
            else    //if right half is sorted 
            {
                high = mid-1;
               if(arr.get(mid)<ans)
               {
                   index = mid;
                   ans = arr.get(mid);
               }
            }
        } 
        return index;     
    }
}