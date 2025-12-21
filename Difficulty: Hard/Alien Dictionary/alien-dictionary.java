import java.util.*;

class Solution {
    public String findOrder(String[] words) {
        int V = 26; // lowercase letters
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        boolean[] present = new boolean[V];

        // mark present characters
        for (String w : words) {
            for (char c : w.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // build graph
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a')
                       .add(s2.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }

            // prefix invalid case
            if (!found && s1.length() > s2.length()) {
                return "";
            }
        }

        // topological sort
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int nbr : adj.get(i)) {
                indegree[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0 && present[i]) {
                q.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.append((char)(node + 'a'));
            count++;

            for (int nbr : adj.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        // cycle check
        int totalChars = 0;
        for (boolean b : present) if (b) totalChars++;

        if (count != totalChars) return "";

        return ans.toString();
    }
}
