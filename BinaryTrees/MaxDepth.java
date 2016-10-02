/**
 * finding max depth of  a binary tree.
**/
class MaxDepth {
     public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }
    
    public int findMaxDepth(TreeNode root, int height) {
        
        if(root == null) {
            return height;
        }
        
        int leftDepth = findMaxDepth(root.left, height + 1);
        int rightDepth = findMaxDepth(root.right, height+1);
        
        if(leftDepth > rightDepth) {
            return leftDepth;
        }
        return rightDepth;
        
    }
}