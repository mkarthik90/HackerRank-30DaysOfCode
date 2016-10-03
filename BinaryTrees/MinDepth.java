/**
 * Find the minimum depth of  a tree
**/
class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        return findMinDepth(root, 1);
    }
    
    public int findMinDepth(TreeNode root, int height) {
        
        if(root == null) {
            return height;
        }
        
        // Checking if its a leaf node
        if(root.left ==null && root.right == null) {
            return height;
        }
        
        if(root.left == null) {
            // REcur right sub tree
            return findMinDepth(root.right, height + 1);
        }
        
        if(root.right == null) {
            //Recur left sub tree
            return findMinDepth(root.left, height + 1);
        }
        
            int leftDepth = findMinDepth(root.left, height + 1);
            int rightDepth = findMinDepth(root.right, height + 1);
            if(leftDepth  < rightDepth) {
                return leftDepth;
            }
            return rightDepth;
        
    }
}