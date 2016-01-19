
public class LinkList {

	public Node head;

	public void insertAtLast(int value) {

		if (head == null) {
			head = new Node();
			head.element = value;
			head.next = null;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			Node node = new Node();
			node.element = value;
			node.next = null;
			current.next = node;
		}
	}

	public void delete(int value) {
		Node current = head;
		Node previous = head;

		while (current != null) {
			if (head.element == value) {
				head = current.next;
				current = current.next;
			} else if (current.element == value) {
				previous.next = current.next;
				current = current.next;
			} else {
				previous = current;
				current = current.next;
			}

		}
	}

	public void printLinkList() {
		System.out.println();
		Node current = head;
		while (current != null) {
			System.out.print(current.element + "->");
			current = current.next;
		}
	}

	public boolean search(int value) {
		Node current = head;
		while (current != null) {
			if (current.element == value)
				return true;
			current = current.next;
		}
		return false;
	}

	/*
	 * Compare two linked lists A and B Return 1 if they are identical and 0 if
	 * they are not. Node is defined as class Node { int element; Node next; }
	 */
	int CompareLists(Node headA, Node headB) {

		while (headA != null && headB != null) {
			if (headA.element != headB.element) {
				return 0;
			}
			headA = headA.next;
			headB = headB.next;
		}
		if (headA != null) {
			return 0;
		} else if (headB != null) {
			return 0;
		}
		return 1;
	}

	public Node Reverse(Node head) {

		if (head == null) {
			return head;
		}

		else if (head.next == null) {
			return head;
		}

		Node previous = head.next;
		Node current = head.next.next;
		previous.next = null;
		while (current != null && current.next != null) {

			Node temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;

		}

		current.next = previous;

		Node newHead = current;

		while (current.next != null) {

			current = current.next;

		}

		current.next = head;
		current.next.next = null;

		return newHead;

	}

	Node MergeLists(Node headA, Node headB) {

		Node mergedNode = null;

		if (headA != null && headB != null) {
			if (headA.element < headB.element) {
				Node temp = new Node();
				temp.element = headA.element;
				temp.next = null;
				headA = headA.next;
				mergedNode = temp;
			}

			else {
				Node temp = new Node();
				temp.element = headB.element;
				temp.next = null;
				headB = headB.next;
				mergedNode = temp;
			}
		}
		Node tail = mergedNode;

		while (headA != null && headB != null) {
			Node temp = new Node();
			if (headA.element < headB.element) {
				temp.element = headA.element;
				headA = headA.next;
			} else {
				temp.element = headB.element;
				headB = headB.next;
			}

			if (mergedNode == null) {
				mergedNode = temp;
				tail = mergedNode;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
		}

		while (headA != null) {

			Node temp = new Node();
			temp.element = headA.element;
			headA = headA.next;
			if (mergedNode == null) {
				mergedNode = temp;
				tail = mergedNode;
			} else {
				tail.next = temp;
				tail = tail.next;
			}

		}

		while (headB != null) {

			Node temp = new Node();
			temp.element = headB.element;
			headB = headB.next;
			if (mergedNode == null) {
				mergedNode = temp;
				tail = mergedNode;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
		}

		return mergedNode;
	}

	/*
	 * Get Nth element from the end in a linked list of integers Number of
	 * elements in the list will always be greater than N. Node is defined as
	 * class Node { int element; Node next; }
	 */

	int GetNode(Node head, int n) {
		// This is a "method-only" submission.
		// You only need to complete this method.

		Node referenceNode = head;
		Node currentNode = head;

		while (n >= 0) {
			referenceNode = referenceNode.next;
			n--;
		}

		while (referenceNode != null) {
			currentNode = currentNode.next;
			referenceNode = referenceNode.next;
		}

		return currentNode.element;
	}

	/*
	 * Node is defined as class Node { int element; Node next; }
	 */

	Node RemoveDuplicates(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.

		Node temp = head.next;
		while (temp.next != null) {
			if (temp.element == temp.next.element) {
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return head;

	}

	int HasCycle(Node head) {

		if (head == null) {
			return 0;
		}

		Node slowPointer = head;
		Node fastPointer = head;

		while (fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if (slowPointer == fastPointer) {
				return 1;
			}
		}
		return 0;
	}

	/*
	 * Insert Node at the end of a linked list head pointer input could be NULL
	 * as well for empty list Node is defined as class Node { int data; Node
	 * next; }
	 */
	int FindMergeNode(Node headA, Node headB) {

		// 1) Find the length of both the linkedlist
		// 2) Find the difference between both the length
		// 3) Iterate the larger one till the difference.
		// 4) Start iterating both after the difference is reached

		Node tempA = headA;
		Node tempB = headB;
		int sizeA = 0;
		int sizeB = 0;
		int difference = 0;
		while (tempA != null) {
			sizeA++;
			tempA = tempA.next;
		}

		while (tempB != null) {
			sizeB++;
			tempB = tempB.next;
		}

		tempA = headA;
		tempB = headB;
		if (sizeA > sizeB) {
			difference = sizeA - sizeB;
			while (difference != 0) {
				tempA = tempA.next;
				difference--;
			}
		} else {
			difference = sizeB - sizeA;
			while (difference != 0) {
				tempB = tempB.next;
				difference--;
			}
		}

		while (tempA != null && tempB != null) {

			if (tempA == tempB) {
				return tempA.element;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}

		return 0;

	}

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.insertAtLast(67);
		list.insertAtLast(67);
		list.insertAtLast(76);
		list.insertAtLast(76);
		list.insertAtLast(86);
		list.printLinkList();
		list.delete(76);
		list.printLinkList();

		System.out.println(list.search(67) ? "Exists" : "Does Not exists");
	}

}
