class Solution {
    class Pair{
        int src;
        int par;
        Pair(int src,int par)
        {
            this.src = src;
            this.par = par;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //make adjlist from adj matrix
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(checkForCycle(adj,i,vis)) return true;
            }
        }
        return false;
    }
    boolean checkForCycle(ArrayList<ArrayList<Integer>> adj,int src,boolean[]vis)
    {
        vis[src] = true;
        Queue<Pair>q = new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int source = curr.src;
            int parent = curr.par;
        for(int nbr : adj.get(source))
        {
            if(!vis[nbr])
            {
                vis[nbr] = true;
                q.add(new Pair(nbr,source));
            }
            else if(parent!=nbr) return true; 
        }
        }
        return false;
        
    }
}