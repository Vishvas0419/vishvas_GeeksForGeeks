class Tree {
    int findCeil(Node root, int key) {
        int ceil = -1;
        while(root!=null)
        {
            if(root.data==key) return root.data;
            if(key>root.data)
            {
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
        
    }
}