package Node;

public class Node {
	String doiT = ""; // 할일
	Node next = null; //다음노드 주소
	static Node end; //마지막노드 주소
	static int number = 0; //순서
	
	Node() 	{
		this("");
	}
	public Node(String a) {
		doiT = a;
	}
	
//	{
//		if (number == 0) {
//			Node firstNode = new Node();
//		}
//	}
	
	public boolean append(String a) {//할일 추가
		try {

			Node newNode = new Node(a);
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
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	boolean append(int b , String a) {
		try {
			Node newNode = new Node(a);
			Node n = this;
			while(n.next != null) {
				if (n.next.number == b)
				{
					newNode.next = n.next;
					n.next = newNode;
				}
			}			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean Delete(String a) {
		try {
			Node n = this;
			while(n.next != null) {
				if (n.next.doiT.equals(a)) {
					n.next = n.next.next;
				} else {
					n = n.next;
				}
			}
		return true;
		}
		catch(Exception e) {
			return false;
		}	
	}
	boolean Delete(int b) {
		try {
			
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	public boolean retvive() {
		try {
			int count = 0;
			Node n = this;
			while(n.next != null) {
				count++;
				System.out.println(count+". "+n.doiT);
				n = n.next;
			}
			System.out.println(count+". "+n.doiT);
		return true;
		}
		catch(Exception e) {
			System.out.println("false");
			return false;
		}
	}
	boolean checklist(String a) {
		try {
			
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
