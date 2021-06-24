package ru.sber.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.sber.Application;
import ru.sber.entity.Message;
import ru.sber.service.MessageService;

//@Sql({ "/schema.sql", "/insert.sql" })
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class MessageRepositoryTest {

    @Autowired
    private static MessageService messageService;

    @BeforeAll
    static void insert(){
        Message message = new Message();
        message.setMessage("aaaa");
        messageService.save(message);
        System.out.println("Saved");
    }

    @Test
    void findAllByShowIsTrueOrderById() {

    }

    @Test
    void findFirstByShowIsTrueOrderByIdDesc() {
    }

    @Test
    void countByShowIsTrue() {
    }

    @Test
    void findFirstByShowIsTrueOrderById() {
    }
}