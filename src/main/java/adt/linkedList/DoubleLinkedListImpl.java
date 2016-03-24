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
		
            
		
	}

	@Override
	public void removeLast() {
		
    }

	

}
