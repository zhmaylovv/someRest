package ru.sber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sber.entity.Message;
import ru.sber.service.MessageService;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/offer")
    public ResponseEntity offer(@RequestBody Message message) {
        try {
            messageService.save(message);
            return ResponseEntity.ok("MessageSave");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/poll")
    public ResponseEntity poll() {
        try {
            messageService.poll();
            return ResponseEntity.ok("MessagePoll");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/peek")
    public ResponseEntity peek() {
        try {
            messageService.peek();
            return ResponseEntity.ok("MessagePeek");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/peekMax")
    public ResponseEntity peekMax() {
        try {
            messageService.peekMax();
            return ResponseEntity.ok("MessageMax");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/all")
    public ResponseEntity all() {
        try {
            messageService.all();
            return ResponseEntity.ok("MessageAll");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }


    @GetMapping("")
    public ResponseEntity getUser() {
        try {
            return ResponseEntity.ok("/all, /peekMax, /peek, /poll, /offer");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
