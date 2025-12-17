class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr)
        {
            pq.add(i);
        }
        int total = 0;
        while(pq.size()>1)
        {
            int a = pq.poll();
            int b = pq.poll();
            int cost = a+b;
            total += cost;
            pq.add(cost);
        }
        return total;
    }
}