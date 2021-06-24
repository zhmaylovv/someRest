package ru.sber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.entity.Message;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message, Long> {
    /**
     * Метод получения из списка элементов очереди сортируемый в порядке очереди.
     *
     * @return Список сущностей.
     */
    List<Message> findAllByShowIsTrueOrderById();

    /**
     * Метод получения из бд максимального элемента очереди.
     *
     * @return Сущность Message.
     */
    Message findFirstByShowIsTrueOrderByIdDesc();

    /**
     * Утилитный запрос для подсчета колличества этементов в очереди.
     */
    Integer countByShowIsTrue();

    /**
     * Метод получения первого элемента очереди.
     */
    Message findFirstByShowIsTrueOrderById();

}
