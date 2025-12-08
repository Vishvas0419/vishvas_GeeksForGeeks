class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int e[] : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v); //for directed graph
        }
        
        boolean [] vis = new boolean[V];
        boolean [] pathVis = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(dfs(i,adj,vis,pathVis)) return true;
            }
        }
        return false;
    }
    static boolean dfs(int node,List<List<Integer>>adj,boolean[]vis,boolean[]pathVis)
    {
        vis[node] = true;
        pathVis[node] = true;
        //traverse through the nbrs and check for cycle
        for(int nbr : adj.get(node))
        {
            //when node is not visited
            if(!vis[nbr])
            {
                if(dfs(nbr,adj,vis,pathVis)) return true;
            }
            //when node is visited but to be visited on the same path
            else if(pathVis[nbr]) return true;   
        }
        pathVis[node] = false; //once path is finished mark that node pathvis =  false before returning or backtracking
        return false;
    }
}