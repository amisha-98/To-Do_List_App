// Task.java
package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private int id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
    private String priority;
    
    // Constructor
    public Task(int id, String title, String description, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.completedAt = null;
    }
    
    // Constructor for loading from file
    public Task(int id, String title, String description, boolean completed, 
                LocalDateTime createdAt, LocalDateTime completedAt, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.priority = priority;
    }
    
    // Getters and Setters
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
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
        if (completed && completedAt == null) {
            this.completedAt = LocalDateTime.now();
        } else if (!completed) {
            this.completedAt = null;
        }
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
    
    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
    
    public String getPriority() {
        return priority;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    // Format task for file storage
    public String toFileFormat() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String completedAtStr = (completedAt != null) ? completedAt.format(formatter) : "null";
        
        return String.format("%d|%s|%s|%b|%s|%s|%s",
                id, title, description, completed, 
                createdAt.format(formatter), completedAtStr, priority);
    }
    
    // Create task from file format
    public static Task fromFileFormat(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Invalid task format");
        }
        
        int id = Integer.parseInt(parts[0]);
        String title = parts[1];
        String description = parts[2];
        boolean completed = Boolean.parseBoolean(parts[3]);
        LocalDateTime createdAt = LocalDateTime.parse(parts[4]);
        LocalDateTime completedAt = parts[5].equals("null") ? null : LocalDateTime.parse(parts[5]);
        String priority = parts[6];
        
        return new Task(id, title, description, completed, createdAt, completedAt, priority);
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s)", 
                completed ? "✓" : " ", title, description, priority);
    }
}