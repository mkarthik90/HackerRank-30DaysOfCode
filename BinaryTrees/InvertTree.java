
/**
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode tempRoot = root;
        invertTree1(root);
        return tempRoot;
    }
    
    public void invertTree1(TreeNode root) {
        if(root != null) {  
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree1(root.left);
            invertTree1(root.right);
        }
    }
}