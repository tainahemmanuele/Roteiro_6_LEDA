package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	DoubleLinkedListNode<T> last;
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
		newNode.next = head;
		((DoubleLinkedListNode<T>) head).previous  = newNode;
		if(head.isNIL()){
			head = last;
		}
		head =newNode;
	}
	

	@Override
	public void removeFirst() {
		if(!head.isNIL()){
			head = head.getNext();
		}if(head.isNIL()){
			last = (DoubleLinkedListNode<T>) head;
		}
		((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(!last.isNIL()){
				last = last.previous;
			}if(last.isNIL()){
				head = last;
			}
		}
		last.next = new DoubleLinkedListNode();
	}

}
