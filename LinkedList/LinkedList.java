class LinkedList {

	Node head;

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

	/*
	* Insertion method for linkedlist at the front
	*/

	public void push(int val) {
		Node n = new Node(val);
		if(head == null) {
			head = n;
		}
		else {
			n.next = head;
			head = n;
		}
	}

	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data +" -> ");
			temp = temp.next;
		}
	}

	public static void main(String arr[]) {
		LinkedList l = new LinkedList();
		l.push(1);
		l.push(2);
		l.push(10);
		l.push(3);
		l.push(5);

		l.print();

		l.swap(5,1);
		System.out.println("After swapping");
		l.print();

	}
}