//Julia had always been fascinated by Binary Search Trees so her sister gave her the following problem to test her knowledge:

//Given a binary search tree having  nodes (each having a distinct value from  to ), find:
//Here,  denotes the number of nodes at a distance of  from the root.

//Input Format
//
//The first line contains a single integer, , denoting the number of nodes in the tree. 
//The second lines contains  space-separated integers describing the order in which each element was inserted into the BST.
//
//
//Output Format
//
//Print a single integer denoting the answer in a separate line.
//
//Sample Input
//3
//3 1 2
//Sample Output
//3

class JuliaSearch {

    private static Node root;
    // key --> level no , value --> total no of node at that level
    private static Map<Integer, Integer> levelMap = new HashMap<>();
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = Integer.parseInt(scanner.nextLine());
        String data = scanner.nextLine();
        String[] allData = data.split(" ");
        root = new Node();
        root.n = Integer.parseInt(allData[0]);
        root.left = root.right = null;
        
        levelMap.put(0, 1);
        
        for(int i=1; i<numberOfNodes; i++)  {
            insert(root, Integer.parseInt(allData[i]), 1);
        }
    
        
        int total = 0;    
        for (Map.Entry<Integer, Integer> entry : levelMap.entrySet()) {
            int k = entry.getKey() * entry.getValue();
            total =  total + k;
        }
        System.out.println(total);
    }
    
   private static void insert(Node node, int n, int level) {
       
        if (node.n > n) {
            if (node.left == null) {
                Node newNode = new Node();
                newNode.n = n;
                newNode.left = newNode.right = null;
                node.left = newNode;
                if(levelMap.get(level) == null) {
                    levelMap.put(level, 1);
                } else {
                    int noOfNodes = levelMap.get(level);
                    levelMap.put(level, noOfNodes + 1);
                }
                
            } else {
                insert(node.left, n, level+1);
            }
        } else if (node.n < n) {
            if (node.right == null) {
                Node newNode = new Node();
                newNode.n = n;
                newNode.left = newNode.right = null;
                node.right = newNode;
                if(levelMap.get(level) == null) {
                    levelMap.put(level, 1);
                } else {
                    int noOfNodes = levelMap.get(level);
                    levelMap.put(level, noOfNodes + 1);
                }
            } else {
                insert(node.right, n, level+1);
            }
        }
    }
    
    
    private static void printInOrder(Node node) {
        if (node.left != null)
            printInOrder(node.left);
        System.out.print(node.n + " ");
        if (node.right != null)
            printInOrder(node.right);
    }


}

class Node {
    Node left;
    Node right;
    int n;
}