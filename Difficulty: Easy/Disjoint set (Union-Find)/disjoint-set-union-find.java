/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        if(x==par[x]) return x;
        return find(par,par[x]);
    }

    void unionSet(int par[], int x, int z) {
        int xp = find(par,x);
        int zp = find(par,z);
        if(xp!=zp) par[xp] = par[zp];
    }
}