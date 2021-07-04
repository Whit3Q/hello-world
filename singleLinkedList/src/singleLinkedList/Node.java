package singleLinkedList;

public class Node {

	static Node end = null;
	Node next = null;
	int data;
	boolean count = false;
	
	Node() {
		this(0);
	}
	Node(int a) {
		data = a;
	}
		
	void append(int b) {
		Node newNode = new Node(b);
		if (end == null) { 
			end = this;
			Node n = end;
			n.next = newNode;
			end = n.next;
		} else {
			Node n = end;
			n.next = newNode;
			end = n.next;
			}
		}
	void delete(int a) {
		Node n = this;
		while(n.next != null) {
			if(n.next.data == a) {
				n.next = n.next.next;
				if(n.next == null) {
					end = n;
				}
			} else {
				n = n.next;
			}
		}
	}
	void retvive() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.data+">");
			n = n.next;
		}
		System.out.println(n.data);
	}	

}
	
	
//	Node next = null;
//	int data;
//	
//	Node() {
//		this(0);
//	}
//	
//	Node(int data) {
//		this.data = data;
//	}
//	
//	boolean append(int a) {
//		try {
//			Node end = new Node(a);
//			Node n = this;
//			while(n.next != null) {
//				n = n.next;
//			}
//			n.next = end;
//			return true;
//		} catch (Exception e1) {
//			
//			return false;
//		}
//	}
//	boolean delete(int d) {
//		Node n = this;
//		while(n.next !=null) {
//			if(n.next.data == d) {
//				n.next = n.next.next;
//			} else {
//				n = n.next;
//			}
//		}
//		return true;
//	}
//	void retvive() {
//		Node n = this;
//		while(n.next != null) {
//			System.out.print(n.data+">");
//			n = n.next;
//		}
//		System.out.println(n.data);
//	}
//}
