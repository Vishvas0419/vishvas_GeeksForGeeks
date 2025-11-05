/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeafs(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }
    public boolean isLeaf(Node root)
    {
        return (root.left==null && root.right==null);
    }
    public void addLeftBoundary(Node root,ArrayList<Integer> ans)
    {
        Node curr = root.left;
        while(curr!=null)
        {
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr = curr.left;
            else curr=curr.right;
        }
    }
    public void addRightBoundary(Node root,ArrayList<Integer> ans)
    {
        ArrayList<Integer>temp = new ArrayList<>();
        Node curr = root.right;
        while(curr!=null)
        { 
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        Collections.reverse(temp);
        ans.addAll(temp);
    }
    public void addLeafs(Node root,ArrayList<Integer> ans)
    {
        if(isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if(root.left!=null) addLeafs(root.left,ans);
        if(root.right!=null) addLeafs(root.right,ans);
    }
}