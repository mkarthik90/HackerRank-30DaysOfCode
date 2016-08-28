
class Node {
    int data;
    Node left;
    Node right;
}

class PostOrderTraversal {
	void postOrder(Node root) {
	    if(root != null) {
	        postOrder(root.left);
	        postOrder(root.right);
	        System.out.print(root.data+" ");
	           
	    }
	}	
}
