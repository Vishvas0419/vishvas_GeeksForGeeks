// User function Template for Java

class Solution {
    class Pair{
        int x,y,dist;
        Pair(int x,int y,int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int sRow = source[0]; int sCol= source[1];
        int dRow = destination[0]; int dCol = destination[1];
         // If start == destination
        if (sRow == dRow && sCol == dCol) return 0;
        int [][] dist = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[sRow][sCol] = 0;
        Queue<Pair>q = new LinkedList<>();
        q.add(new Pair(sRow,sCol,0));
        int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            int r = curr.x;
            int c = curr.y;
            int d = curr.dist;
            for(int []dir : dirs)
            {
                int newr = dir[0] + r;
                int newc = dir[1] + c;
                if(newr>=0 && newr<n && newc>= 0 && newc<m 
                && grid[newr][newc] == 1 && d+1 < dist[newr][newc])
                {
                    dist[newr][newc] = d+1;
                    if(newr==dRow && newc==dCol) return d+1;
                    q.add(new Pair(newr,newc,d+1));
                }
            }
        }
        return -1;
    }
}
