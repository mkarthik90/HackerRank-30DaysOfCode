import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> returnList = new ArrayList<>();
        
        if(root == null) {
            return returnList;
        }
        
        
        Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);

        Queue<Integer> levelQueue = new java.util.LinkedList<>();
        levelQueue.offer(0);

        int currentLevel = 0;
        List<Integer> eachLevel = new ArrayList<>();

        while (!q.isEmpty()) {

            TreeNode n = q.poll();
            Integer levelNumber = levelQueue.poll();

            if (currentLevel == levelNumber) {
                eachLevel.add(n.val);
            } else {
                returnList.add(eachLevel);
                currentLevel++;
                eachLevel = new ArrayList<Integer>();
                eachLevel.add(n.val);
            }

            if (n.left != null) {
                q.offer(n.left);
                levelQueue.offer(currentLevel + 1);
            }

            if (n.right != null) {
                q.offer(n.right);
                levelQueue.offer(currentLevel + 1);
            }

        }
        // Adding for the last level
        returnList.add(eachLevel);
        return returnList;
    }
}