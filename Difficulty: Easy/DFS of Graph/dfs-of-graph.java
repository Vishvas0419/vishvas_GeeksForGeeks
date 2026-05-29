class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        boolean []vis = new boolean[V];
        vis[0] = true;
        DFS(adj,0,vis,ans);
        return ans;
    }
    void DFS(ArrayList<ArrayList<Integer>> adj,int curr,boolean[]vis,ArrayList<Integer>ans)
    {
        vis[curr] = true;
        ans.add(curr);
        for(int nbr : adj.get(curr))
        {
            if(!vis[nbr])
            {
                DFS(adj,nbr,vis,ans);
            }
        }
    }
}