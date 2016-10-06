class LinkedList {

	Node head;

	/*
	* Adding the number in linkedlist. Numbers are stored in reverse order
	* Input:
	* First List: 5->6->3  // represents number 365
	* Second List: 8->4->2 //  represents number 248
	* Output
	* Resultant list: 3->1->6  // represents number 613
	*/
	public Node addTwoNumbersInReverseOrder(Node l1, Node l2) {
        int carryOver = 0;
        Node head = null;
        while(l1 != null && l2 != null) {
            
            int first = l1.val;
            int second = l2.val;
            
            int result = 0;
            result = first + second + carryOver;
            
            int[] results = calculateResultAndCarryOver(result);
            result = results[0];
            carryOver = results[1];
            
            head = insertLast(head, result);
            
            l2 = l2.next;
            l1 = l1.next;    
        }
        
        while(l1 != null) {
            int result = l1.val + carryOver;
            int[] results = calculateResultAndCarryOver(result);
            result = results[0];
            carryOver = results[1];
            
            head = insertLast(head, result);
            
            l1 = l1.next;
        }
        
        while(l2 != null) {
            int result = 0;
            result = l2.val + carryOver;
            int[] results = calculateResultAndCarryOver(result);
            result = results[0];
            carryOver = results[1];
            
            head = insertLast(head, result);
            l2 = l2.next;
        }
        
        if(carryOver != 0) {
            insertLast(head, carryOver);
        }
        return head;
    }

    /*
	* Program to find the node at which the intersection of two singly linked lists begins.
	* A:          a1 → a2
    *               ↘
    *                 c1 → c2 → c3
    *               ↗            
	* B:     b1 → b2 → b3
    */

    public Node getIntersectionNode(Node headA, Node headB) {
        
        if(headA == null || headB == null){
            return null;
        }
        
        Node tempA = headA;
        Node tempB = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(tempA != null) {
            tempA = tempA.next;
            sizeA++;
        }
        
        while(tempB != null) {
            tempB = tempB.next;
            sizeB++;
        }
        
        tempA = headA;
        tempB = headB;
        int diff = 0;
        if(sizeA > sizeB) {
            // A is the bigger linked list
            diff = sizeA - sizeB;
            while(diff != 0) {
                tempA = tempA.next;
                diff--;
            }
            
            while(tempA !=null && tempB != null) {
                if(tempA.val == tempB.val) {
                    return tempA;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        else {
            diff = sizeB - sizeA;
            while(diff != 0) {
                tempB = tempB.next;
                diff--;
            }
            
            while(tempA != null && tempB != null) {
                if(tempA.val == tempB.val) {
                    return tempB;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        
        return null;
        
    }
    
    private int[] calculateResultAndCarryOver(int result) {
        // Zeroth index contains result, First Index contains carryOver
        int results[] = new int[2];
        
       if((result/10) != 0) {
           results[0] = result%10;
           results[1] = (result/10);
       }
       else {
           results[0] = result;
           results[1] = 0;
       }
       
        return results;
    }
    
    /*
	* Inserting node at the end of the linkedlist
    */
    public Node insertLast(Node head, int val) {
        
        if(head == null) {
            head = new Node(val);
        }
        
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            Node newNode = new Node(val);
            temp.next = newNode;
        }
        
        return head;
    }

	/*
		swapping nodes in linkedlist
	*/

	public void swap (int n1, int n2) {
		if(n1 == n2) {
			return;
		}

		//1. First navigate to the position of n1 with curr, prev nodes
		Node curr1 = head;
		Node prev1 = null;
		while(curr1.data != n1) {
			prev1 = curr1;
			curr1 = curr1.next;
		}

		//2. Similarly for node n2
		Node curr2 = head;
		Node prev2 = null;
		while(curr2.data != n2) {
			prev2 = curr2;
			curr2 = curr2.next;
		}

		if(prev1 == null) {
			head = curr2;
		}
		else {
			prev1.next = curr2;
		}
		
		if(prev2 == null) {
			head = curr1;
		}
		else {
			prev2.next = curr1;
		}
		// swap both nodes
		Node temp = curr1.next;
		curr1.next = curr2.next;
		curr2.next = temp;
	}


	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data +" -> ");
			temp = temp.next;
		}
	}

    /**
    * This function removes duplicate from sorted linked list
    **/
    public Node removeDuplicates(Node head) {
        if(head == null) {
            return head;
        }
        Node tempHead = head;
        while(head.next != null) {
            if(head.val == head.next.val) {
                // Remove head.val and do not move the head
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return tempHead;
    }

	public static void main(String arr[]) {
		LinkedList l = new LinkedList();
		l.insertLast(1);
		l.insertLast(2);
		l.insertLast(10);
		l.insertLast(3);
		l.insertLast(5);

		l.print();

		l.swap(5,1);
		System.out.println("After swapping");
		l.print();

	}
}