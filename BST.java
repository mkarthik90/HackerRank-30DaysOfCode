public class BST {

	TreeNode root;

	public void insertElement(int element) {

		if (root == null) {
			// 1. Creating new root TreeNode
			root = new TreeNode();
			root.right = null;
			root.left = null;
			root.data = element;
		}

		TreeNode TreeNodeToBeInserted = new TreeNode();
		TreeNodeToBeInserted.data = element;
		TreeNode parent = root;
		TreeNode current = root;

		while (current != null) {
			parent = current;

			if (current.data < element) {
				current = current.right;
			}

			else {
				current = current.left;
			}

		}

		if (parent.data < element) {
			parent.right = TreeNodeToBeInserted;
		} else {
			parent.left = TreeNodeToBeInserted;
		}

	}

	public void inorder(TreeNode rootTreeNode) {

		if (rootTreeNode.left != null) {
			inorder(rootTreeNode.left);
		}
		System.out.println(rootTreeNode.data);
		if (rootTreeNode.right != null) {
			inorder(rootTreeNode.right);
		}
	}

	public void preorder(TreeNode rootTreeNode) {

	}
	
	public int findElement(TreeNode root, int n) {
		// Return 1 if element is found
		if (root == null) {
			return 0;
		} else if (n < root.data) {
			return findElement(root.left, n);
		} else if (n > root.data) {
			return findElement(root.right, n);
		} else if (n == root.data) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insertElement(9);
		bst.insertElement(10);
		bst.insertElement(11);
		bst.insertElement(7);
		bst.insertElement(8);
		bst.inorder(bst.root);
		System.out.println(bst.findElement(bst.root, 10));

	}

}
