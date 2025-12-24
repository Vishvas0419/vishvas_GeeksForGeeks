class Solution {
    class Pair{
        int node; int dist;
        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int []e : edges)
        {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int []dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return a.node - b.node;
        });
        set.add(new Pair(src,0));
        while(!set.isEmpty())
        {
            Pair curr = set.pollFirst();
            int u = curr.node;
            for(Pair nbr : adj.get(u))
            {
                int v = nbr.node;
                int wt = nbr.dist;
                //relaxation
                if(dist[u]+wt < dist[v])
                {
                    if(dist[v]!=Integer.MAX_VALUE)
                    {
                        set.remove(new Pair(v,dist[v]));
                    }
                    dist[v] = dist[u]+wt;
                    set.add(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
        
    }
}