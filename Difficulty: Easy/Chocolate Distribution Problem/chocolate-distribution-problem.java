// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int minDiff = arr.get(m-1) - arr.get(0);
        for(int i=1;i<=arr.size()-m;i++)
        {
            minDiff = Math.min(minDiff,arr.get(i+m-1)-arr.get(i));
        }
        return minDiff;
    }
}