class Solution {
    public ArrayList<String> findPermutation(String s) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);   // important

        ArrayList<String> ans = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        backtrack(arr, new StringBuilder(), used, ans);
        return ans;
    }

    static void backtrack(char[] arr, StringBuilder curr,
                          boolean[] used, ArrayList<String> ans) {

        if (curr.length() == arr.length) {
            ans.add(curr.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i]) continue;

            // skip duplicates
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) continue;

            used[i] = true;
            curr.append(arr[i]);

            backtrack(arr, curr, used, ans);

            curr.deleteCharAt(curr.length() - 1);
            used[i] = false;
        }
    }
}
