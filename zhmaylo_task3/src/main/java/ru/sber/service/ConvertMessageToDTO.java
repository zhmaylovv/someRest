package ru.sber.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sber.dto.MessageDTO;
import ru.sber.entity.Message;
import ru.sber.repository.MessageRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс конвертации сущности Message в MessageDTO
 */
public class ConvertMessageToDTO {

    /**
     * Метод конвертации первого элемента очереди в DTO, переназначается Id сущности, на 1.
     * @param message
     * @return обьект DTO
     */
    public static MessageDTO firstMessageToDTO(Message message){
        MessageDTO messageDTO = new MessageDTO(1, message.getMessage());
        return messageDTO;
    }
    /**
     * Метод конвертации максимального элемента очереди в DTO, переназначается Id сущности.
     * @param message
     * @return обьект DTO
     */
    public static MessageDTO maxMessageToDTO(Message message, Integer id){
        MessageDTO messageDTO = new MessageDTO(id, message.getMessage());
        return messageDTO;
    }

    /**
     * Метод конвертации списка элементов в DTO очереди. переназначаются все ID что бы соответствовать
     * порядковому номеру в очереди с 1 до... n
     * @param messageList
     * @return
     */
    public static List<MessageDTO> messageDTOList (List<Message> messageList){
        List<MessageDTO> dtoList = new ArrayList<>();
        Integer id = 1;
        for (Message message : messageList){
            dtoList.add(new MessageDTO(id++, message.getMessage()));
        }
        return dtoList;
    }


}
