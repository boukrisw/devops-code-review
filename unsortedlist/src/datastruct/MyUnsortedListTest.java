package datastruct;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyUnsortedListTest {
	protected UnsortedList<Integer> list1;
	protected UnsortedList<Integer> list2;

	
	
	@Before public void init() {
        list1 = MyUnsortedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list2 = MyUnsortedList.of();
	}
	
	@Test public void isEmptyTest() {
		assertFalse(list1.isEmpty());
		assertTrue(list2.isEmpty());
	}
	
	@Test public void sizeTest() {
		assertEquals(9,list1.size());
		assertEquals(0,list2.size());
	}
	
	@Test public void prependTest() {
		list1.prepend(9);
		list2.prepend(55);
		

		assertEquals(10,list1.size());
		assertEquals(1,list2.size());
		
		Integer first1 = list1.pop();
		Integer first2 = list2.pop();

		assertEquals(Integer.valueOf(9),first1);
		assertEquals(Integer.valueOf(55),first2);
	}
	
	@Test public void appendTest() {
		list1.append(9);
		list2.append(55);
		
		assertEquals(10,list1.size());
		assertEquals(1,list2.size());
		
		Integer last1 = list1.popLast();
		Integer last2 = list2.popLast();

		assertEquals(Integer.valueOf(9),last1);
		assertEquals(Integer.valueOf(55),last2);
	}
	
	@Test public void insertTest() {
		list1.insert(100,3);
		assertEquals(10,list1.size());
		assertEquals(Integer.valueOf(100),list1.remove(3));
		assertEquals("La taille n'a pas changé apres suppression!",9,list1.size());

        list1 = MyUnsortedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
        list1.insert(100,0);
		assertEquals(10,list1.size());
		assertEquals(Integer.valueOf(100),list1.remove(0));
		assertEquals("La taille n'a pas changé apres suppression!",9,list1.size());

		list1 = MyUnsortedList.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
        list1.insert(100,9);
		assertEquals(10,list1.size());

		assertEquals(Integer.valueOf(100),list1.remove(9));	
		assertEquals("La taille n'a pas changé apres suppression!",9,list1.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertTestIndexOutOfBoundsException1() throws Exception{
		list1.insert(100,-1);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertTestIndexOutOfBoundsException2() throws Exception{
		list1.insert(100,10);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertTestIndexOutOfBoundsException3() throws Exception{
		list2.insert(100,1);		
	}
	
	
	@Test public void popTest() {
		Integer res = list1.pop();	
		assertEquals(Integer.valueOf(1),res);
		assertEquals(8,list1.size());

		res = list1.pop();	
		assertEquals(Integer.valueOf(2),res);
		assertEquals(7,list1.size());

		res = list1.pop();	
		assertEquals(Integer.valueOf(3),res);
		assertEquals(6,list1.size());
	}
	
	@Test(expected = EmptyListException.class)
	public void popTestEmptyListException() throws Exception{
		Integer res = list2.pop();		
	}
	
	@Test public void popLastTest() {
		Integer res = list1.popLast();	
		assertEquals(Integer.valueOf(9),res);
		assertEquals("La taille n'a pas changé apres suppression!",8,list1.size());

		res = list1.popLast();	
		assertEquals(Integer.valueOf(8),res);
		assertEquals(7,list1.size());

		res = list1.popLast();	
		assertEquals(Integer.valueOf(7),res);
		assertEquals(6,list1.size());
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastTestEmptyListException() throws Exception{
		Integer res = list2.popLast();		
	}
	
	@Test public void removeTest() {
		Integer res = list1.remove(0);	
		assertEquals(Integer.valueOf(1),res);
		assertEquals(8,list1.size());
		
		res = list1.remove(7);	
		assertEquals(Integer.valueOf(9),res);
		assertEquals("La taille n'a pas changé apres suppression!",7,list1.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeTestIndexOutOfBoundsException1() throws Exception{
		Integer res = list2.remove(-1);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeTestIndexOutOfBoundsException2() throws Exception{
		Integer res = list1.remove(9);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeTestEmptyListException() throws Exception{
		Integer res = list2.remove(0);		
	}
	
	
}
