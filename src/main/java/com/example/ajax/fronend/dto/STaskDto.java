package com.example.ajax.fronend.dto;

public class STaskDto {
    int id;
    String title;
    String description;
    String stage;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStage() {
        return stage;
    }
    public void setStage(String stage) {
        this.stage = stage;
    }
    @Override
    public String toString() {
        return "STaskDto [id=" + id + ", title=" + title + ", description=" + description + ", stage=" + stage + "]";
    }
    
}
