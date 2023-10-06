package com.example.ajax.fronend.service;

import org.springframework.stereotype.Service;

import com.example.ajax.fronend.entity.Message;
import com.example.ajax.fronend.repo.MessageRepo;

@Service
public class MessageService {

    private final MessageRepo messageRepo;

    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public void save(Message message) {
        messageRepo.save(message);
    }
    
}
