// User function Template for Java

class Sol {
    // Function to return the floor of given number in BST.
    int floor(Node root, int key) {
        int floor = -1;
        while(root!=null)
        {
            if(root.data==key) return root.data;
            if(key>root.data)
            {
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
}
