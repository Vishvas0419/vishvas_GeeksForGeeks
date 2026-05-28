class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean[V];
        q.add(0);
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
                    q.add(nbr);
                }
            }
        }
        return ans;
    }
}