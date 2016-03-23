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
		  if (!head.isNIL()) {
	            if (head.equals(last)) {
	                last.next = null;
	                last = last.previous;
	                head = last;
	 
	            } else {
	            	((DoubleLinkedListNode<T>) last.next).previous = (DoubleLinkedListNode<T>) last.next;
	                ((DoubleLinkedListNode<T>) head).previous.next = head.next;
	                head = head.next;
	 
	            }
	        }
	}

	@Override
	public void removeLast() {
		if (!head.isNIL()) {
            if (last == head) {
                last.next = null;
                last = last.previous;
                head = last;
            } else {
                ((DoubleLinkedListNode<T>) last.next).previous = ((DoubleLinkedListNode<T>) last).previous;
                ((DoubleLinkedListNode<T>) last).previous.next = last.next;
                last = last.previous;
            }
        }
    }

	

}
