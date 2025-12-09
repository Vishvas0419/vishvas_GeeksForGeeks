class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        Stack<Integer>st = new Stack<>();
        boolean[]vis = new boolean[V];
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        //build graph in adj list from given 2d edge matrix
        for(int[]e : edges)
        {
            int u = e[0]; int v = e[1];
            adj.get(u).add(v);
        }
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i]) dfs(i,st,vis,adj);
        }
        int i=0;
        while(!st.isEmpty()) result.add(st.pop());
        return result;
    }
    static void dfs(int node,Stack<Integer>st,boolean[]vis,List<List<Integer>> adj)
    {
        vis[node] = true;
        for(int nbr : adj.get(node))
        {
            if(!vis[nbr]) dfs(nbr,st,vis,adj);
        }
        st.push(node);
    }
}