class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        //make indegree array
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        int []indegree = new int[V];
        for(int i=0;i<V;i++)
        {
            for(int nbr : adj.get(i))
            {
                indegree[nbr]++;
            }
        }
        Queue<Integer>q  = new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0) q.add(i);
        }
        ArrayList<Integer>topo = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for(int nbr : adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr]==0)
                {
                    q.add(nbr);
                }
            }
        }
        return topo;
    }
}