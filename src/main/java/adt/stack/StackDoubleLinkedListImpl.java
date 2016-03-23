package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {
	
	protected DoubleLinkedList<T> list;
	protected int size;
	
	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
		
	}
	
	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		}if(element != null){
			list.insertFirst(element);
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}else{
			T [] array = list.toArray();
			T elemento = array[0];
			list.removeFirst();
			return elemento;
		}
	}

	@Override
	public T top() {
		if(isEmpty()){
			return null;
		}
		T []array = list.toArray();
		T elemento = array[0];
		return elemento;
		
		
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		if(list.size() == size){
			return true;
		}
		return false;
	}

}
