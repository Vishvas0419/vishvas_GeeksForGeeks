// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
}
