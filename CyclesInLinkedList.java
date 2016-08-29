/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
*/
    class Node {
        int data;
        Node next;
    }

class CyclesInLinkedList {

    boolean hasCycle(Node head) {
        
        if(head == null){
            return false;
        }
        
        Node slowPointer = head;
        Node fastPointer = head;

        while(fastPointer != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            
            if(fastPointer == slowPointer){
                return true;
            }
        }
        
        return false;
    }
}