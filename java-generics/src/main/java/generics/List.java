package generics;

public class List<T> {

	private Node<T> head;

	public void add(T value) {
		Node<T> node = new Node<T>();
		node.setValue(value);
		node.setNext(head);
		head = node;		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node<T> p = head;
		
		while (p != null) {
			sb.append(p.getValue() + " ");
			p = p.getNext();
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
