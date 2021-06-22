package ru.sber.part2Duplicates;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс реализует три варианта поиска дубликатов.
 */
public class FindDuplicates {

    /**
     * Метод поиска дубликатов с использованием стрима. Пытаемся добавить элемент коллекции в Set, если false,
     * значит это дубликат и мы его возвращаем. К минусам этого метода можно отнести необходимость обьединения коллекций,
     * а так же что это поиск дубликатов а не пересечения.
     */
    public static <T> Set<T> findDuplicatesBySet (Collection<T> list, Collection<T> list2){
        List<T> twoList = new ArrayList<>();
        twoList.addAll(list);
        twoList.addAll(list2);
        Set<T> elements = new HashSet<>();
        return twoList.stream().filter(e-> !elements.add(e))
                .collect(Collectors.toSet());
    }

    /**
     * Метод поиска дубликатов простым перебором в цикле.
     */
    public static <T> List<T> findDuplicatesByFor (Collection<T> list, Collection<T> list2){
        List<T> result = new ArrayList<>();
        for (T element : list){
            if(list2.contains(element)){
                result.add(element);
            }
        }
        return result;
    }

    /**
     * Метод поиска дубликатов с использованием retainAll.
     */
    public static <T> List<T> findDuplicatesByRetain (Collection<T> list, Collection<T> list2){
        List <T> result = new ArrayList<>(list);
        result.retainAll(list2);
        return result;
    }



}
