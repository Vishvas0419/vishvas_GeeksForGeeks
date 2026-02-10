class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        Queue<Integer> q = new LinkedList<>();
        while(j<arr.length)
        {
            if(arr[j]<0)
            {
                q.add(j);
            }
            if(j-i+1<k) j++;
            else if(j-i+1==k)
            {
                if(q.isEmpty())
                {
                    ans.add(0);
                }
                else{
                    ans.add(arr[q.peek()]);
                }
                if(!q.isEmpty() && i==q.peek())
                {
                    q.poll();
                }
                i++;j++;
            }
        }
        return ans;
    }
}