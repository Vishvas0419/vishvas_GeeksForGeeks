class Solution {
    public int[][] adjToMat(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int [][] adjMatrix = new int[n][n];
        for(int u=0;u<n;u++){
            for(int v : adj.get(u))
            {
                adjMatrix[u][v] = 1;
                // adjMatrix[v][u] = 1;
            }
        }
        return adjMatrix;
        
    }
}
