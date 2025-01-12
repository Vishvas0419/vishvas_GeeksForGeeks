//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        int count = 0;
        int original = n; // Store the original value of n
        while(n != 0) {
            int last_digit = n % 10;
            if (last_digit != 0 && original % last_digit == 0) { // Check divisibility and avoid zero
                count++;
            }
            n /= 10; // Remove the last digit
        }
        return count;
    }
}
