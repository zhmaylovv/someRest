package ru.sber.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sber.entity.Message;


public interface MessageRepository extends CrudRepository<Message, Long> {
    public Message
}
