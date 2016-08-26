/*
  Delete Node at a given position in a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
*/
  class Node {
     int data;
     Node next;
}

class LinkedListDeletion {
  Node Delete(Node head, int position) {
        if(head == null) {
            return null;
        }
        
        Node temp = head;
        Node prev = null;
        
        for (int i =0 ; i <position; i++){
           prev = temp;
           temp = temp.next;
        }
        
        // Deleting the last node
        if(temp.next == null) {
            prev.next = null;
        }
        // Node is the first node
        else if (prev == null) {
            head = temp.next;
            temp.next = null;
        }
        // Middle element
        else {
            prev.next = temp.next;
        }

        return head;
  }
  
}

    

