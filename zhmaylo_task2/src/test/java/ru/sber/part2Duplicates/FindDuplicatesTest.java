package ru.sber.part2Duplicates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FindDuplicatesTest {

    @Test
    void findDuplicatesBySet() {
        List<String> testList1 = new ArrayList<>();
        testList1.add("test1");
        testList1.add("test2");
        testList1.add("test3");
        List<String> testList2 = new ArrayList<>();
        testList2.add("test4");
        testList2.add("test5");
        testList2.add("test3");
        List<String> result = new ArrayList<>(FindDuplicates.findDuplicatesBySet(testList1, testList2));
        Assertions.assertEquals("test3", result.get(0));
    }

    @Test
    void findDuplicatesByFor() {
        List<String> testList1 = new ArrayList<>();
        testList1.add("test1");
        testList1.add("test2");
        testList1.add("test3");
        List<String> testList2 = new ArrayList<>();
        testList2.add("test4");
        testList2.add("test5");
        testList2.add("test3");
        List<String> result = new ArrayList<>(FindDuplicates.findDuplicatesByFor(testList1, testList2));
        Assertions.assertEquals("test3", result.get(0));
    }

    @Test
    void findDuplicatesByRetain() {
        List<String> testList1 = new ArrayList<>();
        testList1.add("test1");
        testList1.add("test2");
        testList1.add("test3");
        List<String> testList2 = new ArrayList<>();
        testList2.add("test4");
        testList2.add("test5");
        testList2.add("test3");
        List<String> result = new ArrayList<>(FindDuplicates.findDuplicatesByRetain(testList1, testList2));
        Assertions.assertEquals("test3", result.get(0));
    }


}