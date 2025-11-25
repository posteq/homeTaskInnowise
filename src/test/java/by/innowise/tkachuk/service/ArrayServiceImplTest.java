package by.innowise.tkachuk.service;

import by.innowise.tkachuk.entity.CustomArray;
import by.innowise.tkachuk.exception.UnexpectedValueException;
import by.innowise.tkachuk.service.impl.ArrayServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceImplTest {

    private final ArrayService service = new ArrayServiceImpl();
    List<CustomArray> arr;

    @BeforeEach
    void setUp() {
        arr = List.of(
                new CustomArray(0,new int[]{1,10,-5}),
                new CustomArray(1,new int[]{-5,7,5,1024,-34234,3465,95,10}),
                new CustomArray(2,new int[]{99,78,100,-0,-19312}),
                new CustomArray(3,new int[]{20,20})
        );
    }

    @Test
    void shouldThrowWhenArrayEmpty(){
        //given
        CustomArray i = new CustomArray(1,new int[0]);
        //then
        assertThrows(UnexpectedValueException.class,() -> service.findMinValue(i));
    }

    @Test
    void shouldFindMin() throws UnexpectedValueException {
        //given
        int expected = -5;

        //when
        int actual = service.findMinValue(arr.getFirst());

        //then
        assertEquals(expected, actual);

    }

    @Test
    void shouldFindMaxValue() throws UnexpectedValueException {
        //given
        int expected = 100;

        //when
        int actual = service.findMaxValue(arr.get(2));

        //then
        assertEquals(expected, actual);

    }

    @Test
    void shouldFindSum() {
        //given
        int expected = 40;

        //when
        int actual = service.findSumValue(arr.get(3));

        //then
        assertEquals(expected, actual);

    }

    @Test
    void shouldBubbleSort() {
        //given
        int[] expected = new int[]{-34234,-5,5,7,10,95,1024,3465};

        //when
        int[] actual = service.bubbleSort(arr.get(1));

        //then
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortArraySelectByAgeByAge() {
        //given
        int[] expected = new int[]{-34234,-5,5,7,10,95,1024,3465};

        //when
        int[] actual = service.sortArraySelection(arr.get(1));

        //then
        assertArrayEquals(expected, actual);

    }
}