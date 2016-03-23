package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {
	
	private LinkedList<Integer> lista1;
	private LinkedList<Integer> lista2;
	
	@Before
	public void setUp() throws Exception {
		
		getImplementations();
		
		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);
		
	}
	
	private void getImplementations(){
		//TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new  SingleLinkedListImpl<Integer>();
		lista2 = new SingleLinkedListImpl<Integer>();
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
	public void testToArray() {
		Object[] array =  (Object[])(new Comparable[]{3,2,1});
		Assert.assertArrayEquals(array, lista1.toArray());
	}
}