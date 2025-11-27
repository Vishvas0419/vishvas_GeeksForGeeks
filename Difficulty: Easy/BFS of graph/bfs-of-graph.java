class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer>q = new LinkedList<>();
        int V = adj.size();
        boolean [] vis = new boolean[V];
        q.offer(0); //source node that is given in the question
        vis[0] = true;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans.add(curr);
            vis[curr] = true;
            for(int nbr : adj.get(curr))
            {
                if(!vis[nbr])
                {
                    q.offer(nbr);
                    vis[nbr] = true;
                }
            }
        }
        return ans;
        
        
        
    }
}