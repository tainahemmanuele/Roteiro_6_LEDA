package adt.linkedList;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest {
	
	private DoubleLinkedList<Integer> lista1;
	private DoubleLinkedList<Integer> lista2;
	private DoubleLinkedList<Integer> lista3;
	
	@Before
	public void setUp() throws Exception {

		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		
		// Lista com 1 elemento.
		lista3.insert(1);
	}
	
	private void getImplementations(){
		//TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(lista2.isEmpty());
		Assert.assertFalse(lista1.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
	}

	@Test
	public void testSearch() {
		Assert.assertEquals(3, lista1.search(3).intValue());

	}

	@Test
	public void testInsert() {
		lista2.insert(5);
		Assert.assertEquals(1,lista2.size() );
		Object[] array =  (Object[]) lista2.toArray();
		Assert.assertEquals(5, array[0]);
	}

	@Test
	public void testRemove() {
		lista1.remove(1);
		Assert.assertEquals(2,lista1.size() );

	}

	@Test
	public  void testToArray() {
		Object[] array =  (Object[])(new Comparable[]{3,2,1});
		Assert.assertArrayEquals(array, lista1.toArray());
	}
	
	// Métodos de DoubleLinkedList
	
	@Test
	public void testInsertFirst(){
		lista2.insertFirst(3);
		Object[] array =  (Object[]) lista2.toArray();
		Assert.assertEquals(3, array[0]);
		Assert.assertEquals(3, lista2.search(3).intValue());

		
	}

	@Test
	public void testRemoveFirst(){
		lista1.removeFirst();
		Object[] array =  (Object[]) lista1.toArray();
		Assert.assertEquals(2, array[0]);
		
	}
	
	@Test
	public void testRemoveLast(){
		lista1.removeLast();
		Object[] array =  (Object[]) lista1.toArray();
		Assert.assertEquals(2, array[1]);
	}
}