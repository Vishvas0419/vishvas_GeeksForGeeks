/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        if(par[x]==x) return x;
        par[x] = find(par,par[x]);
        return par[x];
}

    void unionSet(int par[], int x, int z) {
        int px = find(par,x);
        int pz = find(par,z);
        if(px != pz)
        {
            par[px] = pz;
        }
    }
}