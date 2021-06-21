package ru.sber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayIteratorTest {

    @Test
    void checkHasNext() {
        Array[][] array = {{}};
        CustomArrayIterator<?> iterator = new CustomArrayIterator<>(array);
        assertFalse(iterator.hasNext());
        Integer[][] arrayFull = {{1}, {2}};
        CustomArrayIterator<?> iterator2 = new CustomArrayIterator<>(arrayFull);
        assertTrue(iterator2.hasNext());
    }

    @Test
    void next() {
        Integer[][] matrix = {{1, 2, 3}, {}, {4, 5}, {6}};
        CustomArrayIterator<?> iterator = new CustomArrayIterator<>(matrix);
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = new ArrayList<>();
        Collections.addAll(expected, 1, 2, 3, 4, 5, 6);
        while (iterator.hasNext()) {
            actual.add((Integer) iterator.next());
        }
        Assertions.assertEquals(expected, actual);
    }


}