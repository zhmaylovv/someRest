package ru.sber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.dto.MessageDTO;
import ru.sber.entity.Message;
import ru.sber.service.ConvertMessageToDTO;
import ru.sber.service.MessageService;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * Метод внесения элементов в очередь.
     * @param message Текстовое сообщение длинной не более 4000 символов.
     */
    @PostMapping("/offer")
    public ResponseEntity offer(@RequestBody Message message) {
        messageService.save(message);
        return ResponseEntity.ok("MessageSave");
    }

    /**
     * Возвращает первый элемент очереди, изменяя флаг "show" на false
     */
    @GetMapping("/poll")
    public ResponseEntity poll() {
        Message first = messageService.peek();
        MessageDTO result = ConvertMessageToDTO.firstMessageToDTO(first);
        first.setShow(false);
        messageService.poll(first);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод вывода первого элемента очереди, без его "удаления".
     */
    @GetMapping("/peek")
    public ResponseEntity peek() {
        Message result = messageService.peek();
        return ResponseEntity.ok(result);
    }

    /**
     * Метод возвращающий максимальный элемент череди. Отдельным запросом идет подсчет количества элементов очереди,
     * для присвоения id максимального элемента.
     */
    @GetMapping("/peekMax")
    public ResponseEntity peekMax() {
        Message maxMessage = messageService.peekMax();
        Integer id = messageService.countQueue();
        MessageDTO result = ConvertMessageToDTO.maxMessageToDTO(maxMessage, id);
        return ResponseEntity.ok(result);
    }

    /**
     * Метод оттображающий все упорядоченые элементы очереди.
     */
    @GetMapping("/all")
    public ResponseEntity all() {
        List<Message> messageList = messageService.all();
        List<MessageDTO> messageDTOList = ConvertMessageToDTO.messageDTOList(messageList);
        return new ResponseEntity(messageDTOList, HttpStatus.OK);
    }

    /**
     * Метод выводит список доступных команд.
     */
    @GetMapping("")
    public ResponseEntity message() {
        return ResponseEntity.ok("/all, /peekMax, /peek, /poll, /offer");
    }
}
