class BinaryTree{
	
	/*
	* Finds the height or depth of the binary tree.
	*/
	public static int height(Node root) {
		if(root == null) {
			return null;
		}
		else {
			int lDepth = height(root.left);
			int rDepth = height(root.right);
			if(lDepth > rDepth) {
				return lDepth + 1;
			}
			else {
				return rDepth + 1;
			}
		}
	}

	public static void insert(Node root, int val) {
		Node prev = null;
		Node tempRoot = null;
		while(root != null) {
			prev = root;
			if(root.data < val) {
				root = root.right;
			}
			else {
				root = root.left;
			}
		}

		if(prev == null) {
			// Root Node insertion
			Node node = new Node(val);
			return node;
		}
		else {
			Node node = new Node(val);
			prev.right = node;
			return tempRoot;
		}
	}

	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		else {
			inOrder(root.left);
			System.out.print(root.data);
			inOrder(root.right);

		}
	}

	public static void main(String arr[]) {
		
	}
}