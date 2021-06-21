package ru.sber;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayIterator<T> implements Iterator<T> {
    private final int size;
    private final T[][] array;
    int iter = 0;
    int lvl1;
    int lvl2;

    public CustomArrayIterator(T[][] array) {
        this.array = array;
        this.size = getSize(array);
        this.lvl1 = 0;
        this.lvl2 = 0;
    }

    private int getSize(T[][] array) {
        int count = 0;
        for (T[] lvl2 : array) {
            count += lvl2.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return iter < size;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = array[lvl1][lvl2];
        iter++;
        lvl2++;
        if (lvl2 >= array[lvl1].length) {
            lvl2 = 0;
            lvl1++;
        }
        try {
            if (array[lvl1].length == 0) {
                lvl1++;
            }
        } catch (IndexOutOfBoundsException e) {
            return element;
        }

        return element;
    }

}
