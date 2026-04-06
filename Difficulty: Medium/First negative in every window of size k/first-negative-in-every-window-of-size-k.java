class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i=0,j=0;
        while(j<arr.length)
        {
            if(arr[j]<0)
            {
                q.add(j);
            }
            if(j-i+1==k)
            {
                if(q.isEmpty()) ans.add(0);
                else
                {
                    ans.add(arr[q.peek()]);
                }
                //reverse calculations done earlier before sliding the window 
                if(!q.isEmpty() && i==q.peek())
                {
                    q.poll();
                }
                
                i++; //slide the window
            }
            j++; //if not reavhed the size yet,then increase the window
            
        }
        return ans;
    }
}