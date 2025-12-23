class Solution {
    class Pair{
        int node;int dist;
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
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;
            // If the distance we popped is worse than the already known shortest distance, skip it
            if(d>dist[u]) continue;
            for(Pair nbr : adj.get(u))
            {
                int v = nbr.node;
                int wt = nbr.dist;
                if(dist[u]+wt < dist[v])
                {
                    dist[v] = dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
            
        }
        return dist; 
    }
}