package ru.sber.service;

import org.springframework.stereotype.Service;
import ru.sber.entity.Message;
import ru.sber.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Метод сохранения обьекта Message в БД, перед сохранением проводится валидация на длинн у сообщения.
     *
     */
    public void save(Message message) {
        if (!validate(message)) {
            throw new IllegalArgumentException("Message too long");
        } else {
            messageRepository.save(message);
        }

    }

    /**
     * Метод сохранения сущности в БД, без валидации. Используется для изменения статуса show
     *
     */
    public void poll(Message message) {
        messageRepository.saveAndFlush(message);
    }

    /**
     * Метод получения первого элемента очереди с учетом show.
     */
    public Message peek() {
        return messageRepository.findFirstByShowIsTrueOrderById();
    }

    /**
     * Метод получения первого элемента очереди с учетом show флага.
     */
    public Message peekMax() {
        return messageRepository.findFirstByShowIsTrueOrderByIdDesc();
    }

    /**
     * Метод получения списка элементов очереди с учетом флага show.
     */
    public List<Message> all() {
        return messageRepository.findAllByShowIsTrueOrderById();
    }

    /**
     * Метод подсчета количества элементов очередь
     */
    public Integer countQueue() {
        return messageRepository.countByShowIsTrue();
    }

    /**
     * Метод валидации. Проеряет длинну поля message. Не более 4000.
     *
     */
    public boolean validate(Message message) {
        return message.getMessage().length() <= 40000;
    }
}
