class Solution {
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []e : edges)
        {
            int u = e[0]; int v = e[1]; int w = e[2];
            adj.get(u).add(new int[]{u,v,w});
            adj.get(v).add(new int[]{v,u,w});
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[] vis = new boolean[V];
        pq.offer(new int[]{-1,0,0});
        int sum = 0;
        int count = 0;
        while(!pq.isEmpty() && count<V)
        {
            int[] curr = pq.poll();
            int pas = curr[0];
            int node = curr[1];
            int wt = curr[2];
            if(vis[node]) continue;
            vis[node] = true;
            sum += wt;
            count++;
            for(int[] n : adj.get(node))
            {
                int np = n[0];
                int nbr = n[1];
                int nw = n[2];
                if(!vis[nbr]) pq.offer(new int[]{np,nbr,nw});
            }
        }
        return sum;
    }
}
