class Solution {
    class P{
        int adjnode;int wt;
        P(int adjnode,int wt)
        {
            this.adjnode = adjnode;
            this.wt = wt;
        }
    }
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight)
        {
            this.node = node;
            this.weight = weight;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        List<List<P>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []e : edges)
        {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new P(v,wt));
            adj.get(v).add(new P(u,wt));
        }
        boolean []vis = new boolean[V];
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;
            if(!vis[node])
            {
                vis[node] = true;
                sum += wt;
                for(P nbr : adj.get(node))
                {
                    int nbrwt = nbr.wt;
                    int nbrnode = nbr.adjnode;
                    if(!vis[nbrnode])
                    {
                        pq.add(new Pair(nbrnode,nbrwt));
                    }
                }
            }
        }
        return sum;
    }
}
