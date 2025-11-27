class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();
        boolean [] vis = new boolean[V];
        vis[0] = true;
        helper(adj,0,vis,ans);
        return ans;
    }
    public void helper(ArrayList<ArrayList<Integer>> adj,int curr,boolean []vis,ArrayList<Integer>ans)
    {
        vis[curr] = true;
        ans.add(curr); 
        for(int nbr : adj.get(curr))
        {
            if(!vis[nbr]) helper(adj,nbr,vis,ans);
        }
    }
}