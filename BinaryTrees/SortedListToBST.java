class SortedlistToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return frameTree(nums, 0, nums.length-1);
    }
    
    public TreeNode frameTree(int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex) {
            return null;
        }
        int mid = (startIndex + endIndex)/2;
        TreeNode node = new TreeNode(nums[mid]);
        /** Recurssively construct left and right sub trees**/
        node.left = frameTree(nums, startIndex, mid-1);
        node.right = frameTree(nums, mid+1, endIndex);
        
        return node;
        
    }
}