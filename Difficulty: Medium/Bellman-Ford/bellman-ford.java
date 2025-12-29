// User function Template for Java

class Solution {
    class Pair{
        int u;
        int v;
        int wt;
        Pair(int u,int v,int wt)
        {
            this.u = u;
            this.v= v;
            this.wt = wt;
        }
    }
    public int[] bellmanFord(int V, int[][] edges, int src) {
        List<Pair> adj = new ArrayList<>();
        for(int[]e : edges)
        {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.add(new Pair(u,v,wt));
        }
        int []dist = new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i] = (int)1e8;
        }
        dist[src] = 0;
        for(int i=0;i<V-1;i++)
        {
            for(Pair edge : adj)
            {
                if(dist[edge.u] != (int)1e8 && 
                dist[edge.u] + edge.wt < dist[edge.v])                {
                    dist[edge.v] = dist[edge.u] + edge.wt;
                }
            }
        }
        
            for(Pair edge : adj)
            {
                if(dist[edge.u] != (int)1e8 && 
                dist[edge.u] + edge.wt < dist[edge.v])
                {
                    return new int[]{-1};
                }
            }
            return dist;
    }
}
