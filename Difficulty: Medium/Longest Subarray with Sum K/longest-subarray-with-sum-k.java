// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        map.put(0, -1); // virtual left before array

        for(int right = 0; right < arr.length; right++)
        {
            // expand window
            prefixSum += arr[right];

            // instead of shrinking → check if valid window exists
            if(map.containsKey(prefixSum - k))
            {
                int leftIndex = map.get(prefixSum - k);
                maxLen = Math.max(maxLen, right - leftIndex);
            }

            // store first occurrence (smallest left)
            map.putIfAbsent(prefixSum, right);
        }

        return maxLen;
    }
}
