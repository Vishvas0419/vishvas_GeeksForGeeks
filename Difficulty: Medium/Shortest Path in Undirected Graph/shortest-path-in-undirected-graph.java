class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []e : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //make a distance array
        int[]dist = new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty())
        {
            int node= q.poll();
            for(int nbr : adj.get(node))
            {
                if(dist[nbr]==Integer.MAX_VALUE)
                {
                    dist[nbr] = dist[node]+1;
                    q.add(nbr);
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(dist[i]==Integer.MAX_VALUE) dist[i] = -1;
        }
        return dist;
    }
}
