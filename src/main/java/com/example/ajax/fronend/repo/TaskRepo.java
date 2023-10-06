package com.example.ajax.fronend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ajax.fronend.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {



}