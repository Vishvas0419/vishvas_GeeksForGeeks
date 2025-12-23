// User function Template for Java
class Solution {
    class Pair{
        int first; int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        for(int e[] : edges){
            int u = e[0]; //node
            int v = e[1]; //nbr
            int wt = e[2]; //weight
            adj.get(u).add(new Pair(v,wt));
        }
        
        //find topo sort
        boolean[]vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(!vis[i]) topoSort(i,vis,st,adj);
        }
        
        int[]dist = new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        
        //relax the edges in topo order
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(dist[node]!=Integer.MAX_VALUE)
            {
                for(Pair nbr : adj.get(node))
                {
                    int v = nbr.first;
                    int wt = nbr.second;
                    if(dist[node]+wt < dist[v])
                    {
                        dist[v] = dist[node] + wt; //relaxing the edge
                    }
                }
            }
        }
        for(int i=0;i<V;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i]=-1;
            }
        }
        return dist;
        
        
    }
    public void topoSort(int node,boolean[]vis,Stack<Integer>st,List<List<Pair>>adj){
        vis[node] = true;
        for(Pair nbr : adj.get(node))
        {
            if(!vis[nbr.first])
            {
                topoSort(nbr.first,vis,st,adj);
            }
        }
        st.push(node);
    }

}