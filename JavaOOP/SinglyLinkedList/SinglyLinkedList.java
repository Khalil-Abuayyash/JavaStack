public class SinglyLinkedList {
	public Node head;
	public SinglyLinkedList() {
		this.head = null;
	}
	public void add(int value) {
		Node newNode = new Node(value);
		if (this.head == null) {
			head = newNode;
		}
		else {
			Node runner = this.head;
			while(runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}
	public Node remove() {
		Node runner = this.head;
		while(runner.next.next != null) {
			runner = runner.next;
		}
		Node removed = runner.next;
		runner.next = null;
		return removed;
	}
	public void printValues() {
		Node runner = this.head;
		while (runner != null) {
			System.out.println(runner.value);
			runner = runner.next;
		}
	}
}
