package com.example.ajax.fronend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ajax.fronend.entity.Message;

public interface MessageRepo extends JpaRepository<Message, Integer> {
    
}
