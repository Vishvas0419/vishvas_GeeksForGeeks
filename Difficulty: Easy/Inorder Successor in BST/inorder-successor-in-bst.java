/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root,list);   
        for(int val : list)
        {
            if(val>x.data) return val;
        }
        return -1;
        
    }
    public Node inorder(Node root,ArrayList<Integer>list)
    {
        if(root==null) return null;
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
        return root;
    }
}