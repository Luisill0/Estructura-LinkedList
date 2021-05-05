package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    void whenANewList_ThenSizeIsZero(){
        List<Integer> list = new ArrayList<>();

        assertEquals(0,list.getSize());
    }

    @Test
    void givenANewList_whenAdd_thenSizeIsOne(){
        List<Integer> list = new ArrayList<>();

        list.add(5);

        assertEquals(1,list.getSize());
    }

    @Test
    void givenAListWithOneElement_whenAdd_thenSizeIsTwo(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(5);

        assertEquals(2,list.getSize());
    }

    @Test
    void givenAListWithTwoElements_whenAdd_thenSizeIsThree(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);
        list.add(15);

        assertEquals(3,list.getSize());
    }

    @Test
    void givenAListWithTwoElements_whenGetIndexFour_thenIndexOutOfBoundsExceptionIsThrown(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);

        assertThrows(IndexOutOfBoundsException.class,()->{
            list.get(4);
        });
    }

    @Test
    void givenAListWithTwoElements_whenDelete_thenSizeIsOne(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);

        list.delete(1);

        assertEquals(1,list.getSize());
    }

    @Test
    void givenAListWithFiveElements_whenDeleteIndexOne_thenSizeIsFour(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        list.delete(1);

        assertEquals(4,list.getSize());
        assertEquals(5,list.get(0));
        assertEquals(15,list.get(1));
        assertEquals(20,list.get(2));
        assertEquals(25,list.get(3));
    }

    @Test
    void givenAListWithTwoElements_whenDeleteIndexFour_thenIndexOutOfBoundsExceptionIsThrown(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);

        assertThrows(IndexOutOfBoundsException.class,()->{
            list.delete(4);
        });
    }

    @Test
    void givenAList_whenGetIteratorIsCalled_thenIteratorHasTheFirstElementValue(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);
        list.add(15);

        Iterator<Integer> it = list.getIterator();

        assertEquals(list.get(0),it.next());
    }

    @Test
    void givenAList_whenGetReverseIteratorIsCalled_thenReverseIteratorHasTheLastElementValue(){
        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(10);
        list.add(15);

        Iterator<Integer> it = list.getReverseIterator();

        assertEquals(list.get(2),it.next());
    }

    @Test
    public void givenAnEmptyList_whenGetIterator_thenIteratorHasNextIsFalse(){
        List<Integer> list = new ArrayList<>();

        Iterator<Integer> it = list.getIterator();

        assertFalse(it.hasNext(), "El valor del iterador deberia ser false");
    }

    @Test
    public void givenAnEmptyList_whenGetReverseIterator_thenIteratorHasNextIsFalse(){
        List<Integer> list = new ArrayList<>();

        Iterator<Integer> it = list.getReverseIterator();

        assertFalse(it.hasNext(), "El valor del iterador deberia ser false");
    }
}
