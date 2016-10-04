class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> returnList = new ArrayList<>();
        getPath(root, arr, 0, returnList, sum);   
        return returnList;
    }
    
    
    public void getPath(TreeNode root, List arr, int pathIndex, List<List<Integer>> returnList, int sum) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right==null) {
            List<Integer> path = new ArrayList<>();
            int totalSum = 0;
            for(int i=0; i<pathIndex; i++) {
                Integer k = (Integer)arr.get(i);
                path.add(k);
                totalSum+=k;
            }
            path.add(root.val);
            if((totalSum + root.val) == sum) {
                returnList.add(path);    
            }
        } else {
            if(arr.size() > pathIndex) {
                arr.set(pathIndex, root.val);    
            }
            arr.add(root.val);
            if(root.left!=null) getPath(root.left, arr, pathIndex + 1, returnList, sum);
            if(root.right!=null) getPath(root.right, arr, pathIndex + 1, returnList, sum);
        }
    }
}