// FileHandler.java
package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String DATA_DIR = "data";
    private static final String TASKS_FILE = "tasks.txt";
    private final Path filePath;
    
    public FileHandler() {
        // Create data directory if it doesn't exist
        Path dataDir = Paths.get(DATA_DIR);
        if (!Files.exists(dataDir)) {
            try {
                Files.createDirectories(dataDir);
            } catch (IOException e) {
                System.err.println("Error creating data directory: " + e.getMessage());
            }
        }
        
        this.filePath = dataDir.resolve(TASKS_FILE);
    }
    
    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }
    
    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        
        if (!Files.exists(filePath)) {
            return tasks; // Return empty list if file doesn't exist
        }
        
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        Task task = Task.fromFileFormat(line);
                        tasks.add(task);
                    } catch (Exception e) {
                        System.err.println("Error parsing task line: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading tasks: " + e.getMessage());
        }
        
        return tasks;
    }
    
    public boolean fileExists() {
        return Files.exists(filePath);
    }
    
    public void createEmptyFile() {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            System.err.println("Error creating empty file: " + e.getMessage());
        }
    }
}