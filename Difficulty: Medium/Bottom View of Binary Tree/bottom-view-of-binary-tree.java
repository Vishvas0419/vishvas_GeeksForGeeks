/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/
class Solution {
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            map.put(curr.hd, curr.node.data);  // always overwrite = bottom wins

            if (curr.node.left != null)  q.add(new Pair(curr.node.left,  curr.hd - 1));
            if (curr.node.right != null) q.add(new Pair(curr.node.right, curr.hd + 1));
        }

        result.addAll(map.values());
        return result;
    }
}