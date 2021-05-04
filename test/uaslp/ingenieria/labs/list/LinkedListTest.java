package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    //Given_When_Then
    @Test
    public void whenANewList_ThenListIsEmpty(){
        // When:
        List<Integer> lista = new LinkedList<>();

        // Then:
        // Asserts
        assertEquals(0,lista.getSize(),"Size deberia ser 0");
    }

    @Test
    public void givenANewList_ThenListsCountIncreases(){
        int listsCount = LinkedList.getListsCount();

        new LinkedList<>();

        assertEquals(listsCount + 1,LinkedList.getListsCount(),"ListsCount deberia ser 1");
    }

    @Test
    public void givenANewList_whenAddElement_thenSizeIsOne(){
        List<Integer> list = new LinkedList<>();

        list.add(5);

        assertEquals(1,list.getSize(),"Size deberia ser 1");
    }

    @Test
    public void givenAnExistingListWithOneElement_whenAddElement_thenSizeIsTwo(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);

        assertEquals(2,list.getSize(),"Size deberia ser 2");
    }

    @Test
    public void givenAnExistingListWithOneElement_whenGetElement_thenItReturnsTheElement(){
        List<Integer> list = new LinkedList<>();

        list.add(5);

        assertEquals(5,list.get(0));
    }

    @Test
    public void givenAnExistingListWithFiveElements_whenGetElementFive_thenItReturnsTheElement(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        assertEquals(25,list.get(4));
    }

    @Test
    public void givenAnExistingListWithOneElement_whenDeleteElement_thenSizeIsZero(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.delete(0);
        assertEquals(0,list.getSize(),"Size deberia ser 0");
    }

    @Test
    public void givenAListWithThreeElements_whenDeleteElementIndexIsLessThanZero_thenIndexOutOfBoundsExceptionIsThrown(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);

        assertThrows(IndexOutOfBoundsException.class,()->{
            list.delete(-2);
        });
    }

    @Test
    public void givenAListWithTwoElements_whenDeleteElementIndexGreaterThanSize_thenIndexOutOfBoundsExceptionIsThrown(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);

        assertThrows(IndexOutOfBoundsException.class,()->{
            list.delete(3);
        });
    }

    @Test
    public void givenAListWithFourElements_whenDeleteHead_thenSizeDecreases(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        list.delete(0);

        assertEquals(3,list.getSize(),"Size deberia ser 3");
        assertEquals(10,list.get(0));
        assertEquals(15,list.get(1));
        assertEquals(20,list.get(2));
    }

    @Test
    public void givenAListWithFourElements_whenDeleteTail_thenSizeDecreases(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        list.delete(3);

        assertEquals(3,list.getSize(),"Size deberia ser 3");
        assertEquals(5,list.get(0));
        assertEquals(10,list.get(1));
        assertEquals(15,list.get(2));
    }

    @Test
    public void givenAListWithFourElements_whenDeleteElementInTheMiddle_thenSizeDecreases(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        list.delete(1);

        assertEquals(3,list.getSize(),"Size deberia ser 3");
        assertEquals(5,list.get(0));
        assertEquals(15,list.get(1));
        assertEquals(20,list.get(2));
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorHasTheHeadNodeValue(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);

        Iterator<Integer> it = list.getIterator();

        assertEquals(5,it.next(),"El valor del iterador deberia ser 5");
    }

    @Test
    public void givenAListWithThreeElements_whenGeReverseIterator_thenIteratorHasTheTailNodeValue(){
        List<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(10);
        list.add(15);

        Iterator<Integer> it = list.getReverseIterator();

        assertEquals(15,it.next(),"El valor del iterador deberia ser 15");
    }

    @Test
    public void givenAnEmptyList_whenGetIterator_thenIteratorHasNextIsFalse(){
        List<Integer> list = new LinkedList<>();

        Iterator<Integer> it = list.getIterator();

        assertFalse(it.hasNext(), "El valor del iterador deberia ser false");
    }

    @Test
    public void givenAnEmptyList_whenGetReverseIterator_thenIteratorHasNextIsFalse(){
        List<Integer> list = new LinkedList<>();

        Iterator<Integer> it = list.getReverseIterator();

        assertFalse(it.hasNext(), "El valor del iterador deberia ser false");
    }
}
