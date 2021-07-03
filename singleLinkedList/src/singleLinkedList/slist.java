package singleLinkedList;

public class slist {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node one = new Node(1);
		one.append(2);
		one.append(3);
		one.append(4);
		one.append(5);
		one.retvive();
		one.delete(5);
		one.append(0);
		one.retvive();
	}
}
