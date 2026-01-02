// User function Template for Java
class Solution {
    static int findPar(int []par,int x)
    {
        if(par[x]==x) return x;
        return par[x] = findPar(par,par[x]);
    }
    static void union(int []par,int[]rank,int x,int y)
    {
        int px = findPar(par,x);
        int py = findPar(par,y);
        if(px==py) return;
        if(rank[px]<rank[py]) par[px] = py;
        else if(rank[px]>rank[py]) par[py] = px;
        else{
            par[py] = px;
            rank[px]++;
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        int[]par = new int[V];
        int[]rank = new int[V];
        for(int i=0;i<V;i++)
        {
            par[i] = i;
            rank[i] = 0;
        }
        int mstSum = 0;
        for(int e[] : edges)
        {
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            if(findPar(par,u)!=findPar(par,v))
            {
                mstSum += wt;
                union(par,rank,u,v);
            }
        }
        return mstSum;
    }
}
