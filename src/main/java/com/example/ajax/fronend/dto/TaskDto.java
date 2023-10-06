package com.example.ajax.fronend.dto;

public class TaskDto {
    private int id;
    private String title;
    private String block;
    private String footer;
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
    public String getBlock() {
        return block;
    }
    public void setBlock(String block) {
        this.block = block;
    }
    public String getFooter() {
        return footer;
    }
    public void setFooter(String footer) {
        this.footer = footer;
    }
    @Override
    public String toString() {
        return "TaskDto [id=" + id + ", title=" + title + ", block=" + block + ", footer=" + footer + "]";
    }
    

}
