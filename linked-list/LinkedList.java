class LinkedList {
	private static ListNode head = null;
	private static ListNode tail = null;
	LinkedList(int data) {
		ListNode node = new ListNode(data);
		head = node;
		tail = node;
	}
	
	public void printList(){
		System.out.print("START -> ");
		ListNode ptr = head;
		while(ptr != null){
			System.out.print(ptr.getData()+" -> ");
			ptr = ptr.getNext();
		}
		System.out.println("END");
	}
	
	public void insertHead(int data){
		ListNode node = new ListNode(data);
		if(head == null)
			head = tail = node;
		else{
			node.setNext(head);
			head = node;
		}
	}
	
	public void insertTail(int data){
		ListNode node = new ListNode(data);
		if(head == null)
			head = tail = node;
		else{
			tail.setNext(node);
			tail = node;
		}
	}
	
	public void insertAfterNodeData(int afterThisData, int data){
		ListNode node = new ListNode(data);
		if(head == null)
			head = tail = node;
		else{
			ListNode ptr = head;
			while(ptr.getData() != afterThisData)
				ptr = ptr.getNext();
			node.setNext(ptr.getNext());
			ptr.setNext(node);
		}
	}
	
	public void deleteHead(){
		if(head == null){
			System.out.print("List Empty !");
			return;
		}
		else{
			ListNode ptr = head;
			head = ptr.getNext();
			ptr = null;
		}
	}
	
	public void deleteTail(){
		if(head == null){
			System.out.print("List Empty !");
			return;
		}
		else{
			ListNode ptr = head;
			while(ptr.getNext().getNext() != null)
				ptr = ptr.getNext();
			ptr.setNext(null);
			tail = ptr;
			tail.setNext(null);
		}
	}
	
	public void deleteNodeWithData(int toBeDeleted){
		if(head == null){
			System.out.print("List Empty !");
			return;
		}
		else{
			ListNode ptr = head;
			while(ptr.getNext().getData() != toBeDeleted)
				ptr = ptr.getNext();
			ptr.setNext(ptr.getNext().getNext());
			ptr = ptr.getNext();
			ptr = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList L = new LinkedList(21);
		L.insertHead(15);
		L.insertTail(36);
		L.insertTail(50);
		L.insertTail(45);
		L.insertAfterNodeData(36, 10);
		L.printList();
		L.deleteNodeWithData(10);
		L.printList();
	}
}
