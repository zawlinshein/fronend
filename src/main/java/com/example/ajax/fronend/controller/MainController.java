package com.example.ajax.fronend.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

import com.example.ajax.fronend.dto.STaskDto;
import com.example.ajax.fronend.dto.TaskDto;
import com.example.ajax.fronend.entity.Message;
import com.example.ajax.fronend.entity.Task;
import com.example.ajax.fronend.repo.MessageRepo;
import com.example.ajax.fronend.service.TaskService;
import com.pusher.rest.Pusher;

@Controller
public class MainController {

    private final MessageRepo messageRepo;
    private final TaskService taskService;

    public MainController(MessageRepo messageRepo, TaskService taskService) {
        this.messageRepo = messageRepo;
        this.taskService = taskService;
    }
    
    @GetMapping("/")
    public String homePage() {
        return "layout";
    }

    @PostMapping("/help")   
    @ResponseBody
    public String ihavenoidea(@RequestParam(name = "hello") String hello, HttpSession session) {
        System.out.println("result : ===================== " + hello + "============================= : ");
        return hello;
    }

    @GetMapping("/api/home")
    public ModelAndView home(ModelAndView mav, HttpSession session) {
        mav.addObject("sessionObject", session.getAttribute("sessionvariable"));
        mav.addObject("hi", "this is kinda fun");
        mav.setViewName("body/home");
        return mav;
    }

    @GetMapping("/api/profile")
    public String profile() {
        return "body/profile";
    }

    @GetMapping("/api/register")
    public String register() {
        return "body/register";
    }

    @GetMapping("api/message")
    public String message() {
        return "body/message";
    }

    @GetMapping("/api/dad") 
    public String dad() {
        return "body/dad";
    }

    @GetMapping("/api/tasklist")
    @ResponseBody
    public List<TaskDto> getAllTask() {
        List<Task> tasks = taskService.getAll();
        return tasks.stream()
                .map(task -> mapToDTO(task))    
                .collect(Collectors.toList());
    }

    @GetMapping("/api/stasklist")
    @ResponseBody
    public List<STaskDto> getSAllTaskList() {
        List<Task> tasks = taskService.getAll();
        return tasks.stream()
                .map(task -> SMapToDto(task))    
                .collect(Collectors.toList());
    }

    @PutMapping("/api/task/updateStage/{taskId}/{newStage}")
    public ResponseEntity<?> updateTaskStage(@PathVariable int taskId, @PathVariable String newStage) {
        try {
            // Call the service method to update the task stage
            System.out.println(taskId + newStage);
            Task task = taskService.findById(taskId);
            task.setStatus(newStage);
            taskService.save(task);
            return ResponseEntity.ok("Task stage updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error updating task stage");
        }
    }

    @PostMapping("/api/task/save")
    @ResponseBody
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        // Process and save the task on the server
        // You may want to return a success or error message
        System.out.println(task);
        taskService.save(task);
        return ResponseEntity.ok("Task added successfully");
    }

    @GetMapping("/draganddrop")
    public String ihavenoidea() {
        return "draganddrop";
    }

    @PostMapping("/livecomment")
    @ResponseBody
    public String comment(@RequestBody Map<String, String> requestBody) {

        String comment = requestBody.get("comment");

        System.out.println(comment);

        // Save the comment to the database using your repository
        Message message = new Message();
        message.setMessage(comment);
        messageRepo.save(message);

        Pusher pusher = new Pusher("1529588", "cd7cdc2857a652669f6c", "685bfa38bf47ea7cf2e5");
pusher.setCluster("ap1");
pusher.setEncrypted(true);

// pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", "hello world"));
pusher.trigger("my-channel", "my-event", "{\"comment\":\"" + comment + "\"}");

        return "hi guys";
    } 

    private TaskDto mapToDTO(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setBlock("Task");
        dto.setFooter("<i class=\"ion-md-chatboxes\"></i><div class=\"pull-right\"><i class=\"ion-md-checkbox\"></i> " + task.getDescription() + "</div>");
        return dto;
    }

    private STaskDto SMapToDto(Task task) {
        STaskDto dto = new STaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStage(task.getStatus());
        return dto;
    }
}
