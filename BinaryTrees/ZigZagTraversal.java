class ZigZagTraversal {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Given binary tree [3,9,20,null,null,15,7],
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 *]
 */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) {
            return new ArrayList();
        }
        
        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        Map<Integer, Queue<TreeNode>> map = new HashMap();
        Integer level = 0;
        current.add(root);
        
        //Add the first level
        map.put(level, new LinkedList(current));
        level++;
        
        while(!current.isEmpty()) {
            
            TreeNode n = current.remove();
            if(n.left != null) {
                next.add(n.left);
            }
            if(n.right != null) {
                next.add(n.right);
            }
            
            if(current.isEmpty() && !next.isEmpty()) {
                current = new LinkedList(next);
                map.put(level, new LinkedList(next));
                next = new LinkedList();
                level++;
            }
            
        }
        List<List<Integer>> returnList = new ArrayList<>();
        
        for(Map.Entry<Integer, Queue<TreeNode>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Queue<TreeNode> q = entry.getValue();
            if(key % 2 == 0) {
                List<Integer> r = new ArrayList<>();
                while(!q.isEmpty()) {
                    TreeNode n = q.remove();
                    r.add(n.val);
                }
                returnList.add(r);
            }
            else {
                //Add in reverse order
                List<Integer> r = new ArrayList<>();
                while(!q.isEmpty()) {
                    TreeNode n = q.remove();
                    r.add(0, n.val);
                }
                returnList.add(r);
            }
        }
        return returnList;
    }

}