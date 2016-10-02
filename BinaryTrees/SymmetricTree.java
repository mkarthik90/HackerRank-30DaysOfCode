/**
 * Check if a tree is symmetric
**/
class SymmetricTree {
    public boolean isSymmetric(TreeNode r) {
        if(r == null) {
            return true;
        }
        return checkSymmetric(r.left, r.right);
    }
    
    public boolean checkSymmetric(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) {
            return true;
        }
        
        if(r1 ==null || r2 == null) {
            return false;
        }
        
        if(r1 != null && r2 != null && r1.val == r2.val) {
            return checkSymmetric(r1.left, r2.right) && checkSymmetric(r1.right, r2.left);
        }
        
        return false;
    }
}
