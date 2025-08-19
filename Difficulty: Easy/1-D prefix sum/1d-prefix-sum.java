class Solution {
    public ArrayList<Integer> prefSum(int[] arr) {
        int [] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i : prefixSum)
        {
            result.add(i);
        }
        return result;
    }
}