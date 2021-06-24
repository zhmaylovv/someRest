package ru.sber.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.sber.Application;
import ru.sber.entity.Message;
import ru.sber.repository.MessageRepository;

import static org.junit.jupiter.api.Assertions.*;

@Sql({ "/schema.sql", "/insert.sql" })
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class MessageServiceTest {

    private static MessageRepository messageRepository;
    private static MessageService messageService = new MessageService(messageRepository);

    @BeforeAll
    static void insert(){

        Message message = new Message();
        message.setMessage("aaaa");
        messageService.save(message);
        Mockito.when(messageRepository.saveAndFlush(Mockito.any())).thenReturn(message);
        System.out.println("Saved");
    }

    @Test
    void save() {
    }

    @Test
    void poll() {
    }

    @Test
    void peek() {
    }

    @Test
    void peekMax() {
    }

    @Test
    void all() {
    }

    @Test
    void countQueue() {
    }

    @Test
    void validate() {
    }
}