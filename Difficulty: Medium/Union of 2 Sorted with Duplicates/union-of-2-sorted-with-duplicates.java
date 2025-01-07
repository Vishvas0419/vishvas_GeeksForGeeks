//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        ArrayList<Integer> UnionArr = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                if (UnionArr.size() == 0 || UnionArr.get(UnionArr.size() - 1) != a[i]) {
                    UnionArr.add(a[i]);
                }
                i++;
            } else {
                if (UnionArr.size() == 0 || UnionArr.get(UnionArr.size() - 1) != b[j]) {
                    UnionArr.add(b[j]);
                }
                j++;
            }
        }

        // Add remaining elements of array a
        while (i < n1) {
            if (UnionArr.size() == 0 || UnionArr.get(UnionArr.size() - 1) != a[i]) {
                UnionArr.add(a[i]);
            }
            i++;
        }

        // Add remaining elements of array b
        while (j < n2) {
            if (UnionArr.size() == 0 || UnionArr.get(UnionArr.size() - 1) != b[j]) {
                UnionArr.add(b[j]);
            }
            j++;
        }

        return UnionArr;
    }
}

