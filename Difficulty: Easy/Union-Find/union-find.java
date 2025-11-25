// User function Template for Java

class Solution {
       int find(int par[], int x) {
        if(x==par[x]) return x;
        return par[x]=find(par,par[x]);
    }

    // Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[]) {
        int ap = find(par,a);
        int bp = find(par,b);
        if(ap==bp) return;
        if(rank[ap]>rank[bp]) par[bp] = ap;
        else if(rank[ap]<rank[bp]) par[ap] = bp;
        else 
        {
            par[ap] = bp;
            rank[bp]++;
        }
    }

    // Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[]) {
        return find(par,a) == find(par,b);
    }
}