// TodoManager.java
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoManager {
    private List<Task> tasks;
    private FileHandler fileHandler;
    private int nextId;
    
    public TodoManager() {
        this.tasks = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.nextId = 1;
        loadTasks();
    }
    
    public void addTask(String title, String description, String priority) {
        Task task = new Task(nextId++, title, description, priority);
        tasks.add(task);
        saveTasks();
    }
    
    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
        saveTasks();
    }
    
    public void markTaskCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(true);
                saveTasks();
                break;
            }
        }
    }
    
    public void markTaskIncomplete(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setCompleted(false);
                saveTasks();
                break;
            }
        }
    }
    
    public void updateTask(int id, String title, String description, String priority) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setTitle(title);
                task.setDescription(description);
                task.setPriority(priority);
                saveTasks();
                break;
            }
        }
    }
    
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
    
    public List<Task> getCompletedTasks() {
        return tasks.stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }
    
    public List<Task> getPendingTasks() {
        return tasks.stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.toList());
    }
    
    public List<Task> getTasksByPriority(String priority) {
        return tasks.stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .collect(Collectors.toList());
    }
    
    public Task getTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    private void loadTasks() {
        List<Task> loadedTasks = fileHandler.loadTasks();
        if (loadedTasks != null) {
            tasks.addAll(loadedTasks);
            // Set nextId to be greater than the highest existing ID
            nextId = tasks.stream()
                    .mapToInt(Task::getId)
                    .max()
                    .orElse(0) + 1;
        }
    }
    
    private void saveTasks() {
        fileHandler.saveTasks(tasks);
    }
    
    public int getTaskCount() {
        return tasks.size();
    }
    
    public int getCompletedTaskCount() {
        return (int) tasks.stream().filter(Task::isCompleted).count();
    }
    
    public int getPendingTaskCount() {
        return (int) tasks.stream().filter(task -> !task.isCompleted()).count();
    }
}