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

	public void delete(TreeNode root, int element) {

		/*
		 * 1) If the node does not have any child directly delete the node 2) If
		 * the node have either left of right child replace it with the deleting
		 * node 3) If the node have two child then replace the node with either
		 * the right most element of left subtree or left most element of right
		 * sub tree
		 */
		TreeNode parent = root;
		TreeNode currentRoot = root;
		while (currentRoot != null && currentRoot.data != element) {
			parent = currentRoot;
			if (currentRoot.data < element) {
				currentRoot = currentRoot.right;
			} else if (currentRoot.data > element) {
				currentRoot = currentRoot.left;
			}
		}

		if (currentRoot.left == null && currentRoot.right == null) {
			// Delete current Root and set parent.left or right to null
			if (parent.left == currentRoot) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		else if (currentRoot.left == null) {
			// Replace currentRoot by left NOde
			if (parent.left == currentRoot) {
				parent.left = currentRoot.left;
			} else {
				parent.right = currentRoot.left;
			}
		}

		else if (currentRoot.right == null) {
			// Replace currentRoot by right NOde
			if (parent.left == currentRoot) {
				parent.left = currentRoot.right;
			} else {
				parent.right = currentRoot.right;
			}
		}

		else {

			// In case current node has two nodes
		}

	}

	int height(TreeNode root) {
		if (root == null) {
			return 0;
		}

		else {

			int maxHeight = max(height(root.left), height(root.right));
			return maxHeight + 1;

		}

	}

	int max(int a, int b) {

		if (a > b) {
			return a;
		}
		return b;
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insertElement(9);
		bst.insertElement(10);
		bst.insertElement(11);
		bst.insertElement(7);
		bst.insertElement(8);

		// System.out.println(bst.findElement(bst.root, 10));
		bst.inorder(bst.root);
		/*
		 * bst.delete(bst.root, 8); bst.inorder(bst.root);
		 */

	}

}
