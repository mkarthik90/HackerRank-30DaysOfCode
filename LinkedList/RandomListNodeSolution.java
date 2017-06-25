/**
 * Definition for singly-linked list with a random pointer.
 */
 class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
 };
 
public class RandomListNodeSolution {

    public RandomListNode copyRandomListWithConstantSpace(RandomListNode head) {
        RandomListNode temp = head;
        // Insert the newSource inbetween the existing source node. 
        // 1,2,3,4 => 1,1,2,2,3,3,4,4
        while(temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        
        temp = head;
        
        // Copy the random pointers to the newSource. 
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;    
            }
            temp = temp.next.next;
        }
        
        // Rearrange the nodes
        temp = head;
        RandomListNode newHead = null;
        RandomListNode newSource = newHead;
        while(temp != null) {
            if(newHead == null) {
                newHead = temp.next;
                newSource = newHead;
            } else {
                newSource.next = temp.next;
                newSource = newSource.next;
            }
            temp.next = temp.next.next;            
            temp = temp.next;
        }
        return newHead;
    }

    public RandomListNode copyRandomListWithExtraMemory(RandomListNode head) {
        RandomListNode source = head;
        RandomListNode newSource = null;
        RandomListNode newHead = null;
        while(source != null) {
            if(newSource == null) {
                newSource = new RandomListNode(source.label);    
                newHead = newSource;
            } else {
                RandomListNode newNode = new RandomListNode(source.label);
                newSource.next = newNode;
                newSource = newSource.next;
            }
            source = source.next;
        }
        // Create a hashmap for source/newSource
        Map mapping = new HashMap();
        source = head;
        RandomListNode newRandomList = newHead;
        
        while(source != null) {
            mapping.put(source, newRandomList);
            source = source.next;
            newRandomList = newRandomList.next;
        }
        
        source = head;
        newRandomList = newHead;
        
        while(source != null) {
            newRandomList.random = (RandomListNode) mapping.get(source.random);
            source = source.next;
            newRandomList = newRandomList.next;
        }
        
        return newHead;
    }
}