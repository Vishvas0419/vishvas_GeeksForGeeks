// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int [] result = new int[arr.length];
        int product = 1;
        int zeroes = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0) zeroes++;
            else product *= arr[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            if(zeroes>1) result[i] = 0;
            else if(zeroes==1)
            {
                if(arr[i]==0) result[i] = product;
                else result[i] = 0;
            }
            else result[i] = product / arr[i];
        }
        return result;
        
    }
}
