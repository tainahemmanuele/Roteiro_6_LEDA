package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	
	
	
	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size =0;
		SingleLinkedListNode<T> aux = head;
		while(aux != null && !aux.isNIL()){
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = head;
		if(isEmpty()){
			return null;
		}
		while (!aux.isNIL() && ! aux.getData().equals(element)){
			aux = aux.getNext();
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = head;
		if(head.isNIL()){
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, head);
			newHead.next = head;
			head =newHead;
		}else{
			while(!aux.next.isNIL()){
				aux = aux.next;
			}
		}
		SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
		node.next = aux.next;
		aux.next = node;
	}

	@Override
	public void remove(T element) {
		if(head.getData().equals(element)){
			head = head.next;
		}else{
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> prev = aux;
			while(!aux.isNIL() && !aux.data.equals(element)){
				prev = aux;
				aux = aux.next;
			}if(!aux.isNIL()){
				prev.next = aux.next;
			}
			
		}
	}
	@Override
	public T[] toArray(){
		if(isEmpty()){
			T [] array= (T[]) new Object[0];
			return array;
		}
		T [] array= (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = head;
		for (int j = 0; j < array.length; j++) {
			array[j] = aux.getData();
			aux = aux.getNext();
		}
		return array;
		
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

	
}
