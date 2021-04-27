package uaslp.ingenieria.labs.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    //Given_When_Then
    @Test
    public void whenANewList_ThenListIsEmpty(){
        // Given:

        // When:
        List<Integer> lista = new LinkedList<>();

        // Then:
        // Asserts
        assertEquals(0,lista.getSize());
    }
}
