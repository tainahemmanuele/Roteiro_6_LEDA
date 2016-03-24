package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newNode;
			if (head.isNIL()) {
				head = new DoubleLinkedListNode<T>();
				newNode = new DoubleLinkedListNode<T>(element, last,
						(DoubleLinkedListNode<T>) head);
				head.next = newNode;

				last = newNode;
			} else {
				newNode = new DoubleLinkedListNode<T>(element,
						(DoubleLinkedListNode<T>) head,
						((DoubleLinkedListNode<T>) head).previous);
				((DoubleLinkedListNode<T>) head).previous.next = newNode;
				((DoubleLinkedListNode<T>) head).previous = newNode;
			}
			head = newNode;
		}
	}

	@Override
	public void removeFirst() {
		if (this.size() == 1) {
			head = new DoubleLinkedListNode<T>();
			last = (DoubleLinkedListNode<T>) head;
		} else if (!isEmpty()) {
			((DoubleLinkedListNode<T>) head.getNext()).previous = new DoubleLinkedListNode<T>();
			head = head.getNext();
		}

	}

	@Override
	public void removeLast() {
		if (size() == 1) {
			head = new DoubleLinkedListNode<T>();
			last = (DoubleLinkedListNode<T>) head;
		} else if (!isEmpty()) {
			last.getPrevious().setNext(new DoubleLinkedListNode<T>());
			last = last.getPrevious();

		}

	}
	
	@Override
	public void insert(T element) {
		if(isEmpty()){
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
			head = newNode;
			last = newNode;
			
		}
		else{
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), last);
			last.setNext(newNode);
			last = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if(size()==1 && head.getData().equals(element)){
			head = new DoubleLinkedListNode<T>();
			last = new DoubleLinkedListNode<T>();
			
			
		}else{
			DoubleLinkedListNode<T>aux = (DoubleLinkedListNode<T>) head;
			while(!aux.isNIL() && !aux.getData().equals(element)){
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
			if(aux != null && !aux.getPrevious().isNIL())
				aux.getPrevious().setNext(aux.getNext());
			if(!aux.getNext().isNIL()){
			   ((DoubleLinkedListNode<T>) aux.getNext()).setPrevious(aux.previous);
			}
		}
	}

}
