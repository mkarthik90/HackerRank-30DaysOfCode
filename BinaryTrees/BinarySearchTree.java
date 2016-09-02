class BinarySearchTree {
	
	public static int[] count = new int[10];

	/*
	* Finds the height or depth of the binary tree.
	*/
	public static int height(Node root) {
		if(root == null) {
			return 0;
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

	public static Node insert(Node root, int val) {
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
			System.out.print(root.data+" ");
			inOrder(root.right);

		}
	}

	/*
	* Finding width of each level in a binary tree
	*/
	public static void getWidth(Node root, int level) {
		// If the node is null, then that wont add to that level
		// Similar recurssion as preorder
		if(root != null) {
			count[level]++;
			level++;
			getWidth(root.left, level);
			getWidth(root.right, level);
		}
	}



	public static void main(String arr[]) {
		Node root = insert(null, 50);
		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 90);
		insert(root, 60);
		insert(root, 110);
		
		inOrder(root);
	}
}