class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        boolean [] visitedArr = new boolean[adj.size()];
        q.offer(0);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            ans.add(curr);
            visitedArr[curr] = true;
            for(int nbr : adj.get(curr))
            {
                if(!visitedArr[nbr])
                {
                    q.offer(nbr);
                    visitedArr[nbr] = true;
                }
            }
        }
        return ans;
    }
}