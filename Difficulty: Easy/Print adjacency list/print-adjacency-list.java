// User function Template for Java
class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int [] e : edges)
        {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v); //only for directed graphs
            adj.get(v).add(u); //both for undirected graphs
        }
        return adj;
    }
}