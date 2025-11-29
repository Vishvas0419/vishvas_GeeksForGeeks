class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        boolean [] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans.add(curr);
            for(int nbr : adj.get(curr))
            {
                if(!vis[nbr])
                {
                    vis[nbr] = true;
                    q.offer(nbr);
                }
            }
        }
        return ans;
        
    }
}