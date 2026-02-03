    class Solution {
        public static int smallestSubWithSum(int x, int[] arr) {
            int i=0 ,j=0,minLen = Integer.MAX_VALUE;
            int sum = 0;
            while(j<arr.length)
            {
                sum += arr[j];
                // j++;
                while(sum>x)
                {
                    minLen = Math.min(minLen,j-i+1);
                    sum = sum-arr[i];
                    i++;
                }
                j++;
            }
            return minLen==Integer.MAX_VALUE ? 0 : minLen;
        }
    }
